package client;

import domain.command.Command;
import domain.command.OrderMealCommand;
import domain.command.Waiter;
import domain.composite.MealComponent;
import domain.decorator.BaconDecorator;
import domain.decorator.ExtraCheeseDecorator;
import domain.facade.RestaurantFacade;
import domain.factories.AmericanMealFactory;
import domain.factories.ItalianMealFactory;
import domain.factories.MealFactory;
import domain.models.Meal;
import domain.observer.KitchenDisplay;
import domain.strategy.CardPayment;
import utilities.RestaurantOrderSystem;

public class Main {
    public static void main(String[] args) {
        // Initialize System
        RestaurantOrderSystem system = RestaurantOrderSystem.getInstance();
        RestaurantFacade facade = new RestaurantFacade();


        // 1. OBSERVER PATTERN
        // Register the Kitchen Display to listen for new orders
        System.out.println("[Setup] Connecting Kitchen Display to Order System...");
        system.attach(new KitchenDisplay());

        // 2. COMMAND PATTERN
        // The waiter takes orders (Invoker) but doesn't send them immediately
        Waiter waiter = new Waiter();

        System.out.println("\n--- Customer 1: Placing Order via Command ---");
        MealFactory italianFactory = new ItalianMealFactory("pizza");
        Meal pizza = italianFactory.createMeal();

        // Wrap the request as a command
        Command order1 = new OrderMealCommand(pizza);
        waiter.takeOrder(order1);

        System.out.println("\n--- Customer 2: Placing Custom Order via Command ---");
        MealFactory americanFactory = new AmericanMealFactory();
        Meal burger = americanFactory.createMeal();

        // DECORATOR + COMMAND
        // We use MealComponent here because Decorators implement MealComponent, not Meal
        MealComponent customBurger = new BaconDecorator(new ExtraCheeseDecorator(burger));

        Command order2 = new OrderMealCommand(customBurger);
        waiter.takeOrder(order2);

        // 3. EXECUTE COMMANDS
        // Waiter sends all accumulated orders to the kitchen
        waiter.sendOrdersToKitchen();

        // 4. EXISTING FACADE USAGE
        // You can still use the Facade. Because the system is a Singleton,
        // the Observer (Kitchen) will still catch these orders too!
        System.out.println("\n--- Customer 3: Using Facade (Direct) ---");
        facade.orderFamilyCombo();

        // 5. STRATEGY PATTERN
        // Display totals
        system.displayOrderHistory();
        System.out.println("Total Revenue to Collect: $" + String.format("%.2f", system.getTotalRevenue()));

        // Pay with Card (Strategy 1)
        // Ensure your CardPayment class has the constructor: public CardPayment(String num, String name)
        system.processPayment(new CardPayment("1234-5678-9876-5432", "Daniel Cojocaru"));

    }
}