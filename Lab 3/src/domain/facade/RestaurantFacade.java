// domain/facade/RestaurantFacade.java
package domain.facade;

import domain.builder.BurgerBuilder;
import domain.composite.MealCombo;
import domain.composite.MealComponent;
import domain.decorator.BaconDecorator;
import domain.decorator.DiscountDecorator;
import domain.decorator.ExtraCheeseDecorator;
import domain.factories.AmericanMealFactory;
import domain.factories.HealthyMealFactory;
import domain.factories.ItalianMealFactory;
import domain.factories.MealFactory;
import domain.models.ComboMeal;
import domain.models.Meal;
import utilities.RestaurantOrderSystem;

public class RestaurantFacade {
    private RestaurantOrderSystem orderSystem;

    public RestaurantFacade() {
        this.orderSystem = RestaurantOrderSystem.getInstance();
    }

    // Simple factory-based orders
    public void orderPizza() {
        System.out.println("\n--- Ordering Standard Pizza ---");
        MealFactory factory = new ItalianMealFactory("pizza");
        Meal pizza = factory.orderMeal();
        orderSystem.placeOrder(pizza);
    }

    public void orderBurger() {
        System.out.println("\n--- Ordering Standard Burger ---");
        MealFactory factory = new AmericanMealFactory();
        Meal burger = factory.orderMeal();
        orderSystem.placeOrder(burger);
    }

    public void orderSalad() {
        System.out.println("\n--- Ordering Healthy Salad ---");
        MealFactory factory = new HealthyMealFactory();
        Meal salad = factory.orderMeal();
        orderSystem.placeOrder(salad);
    }

    // Builder-based custom orders
    public void orderCustomBurger(String base, String protein, String toppings) {
        System.out.println("\n--- Building Custom Burger ---");
        Meal customBurger = new BurgerBuilder()
                .setBase(base)
                .addProtein(protein)
                .addToppings(toppings)
                .addSauce("Special Sauce")
                .build();

        customBurger.prepare();
        customBurger.serve();
        customBurger.displayInfo();
        orderSystem.placeOrder(customBurger);
    }

    // Decorator-based orders (with extras)
    public void orderBurgerWithExtras() {
        System.out.println("\n--- Ordering Deluxe Burger with Extras ---");
        MealFactory factory = new AmericanMealFactory();
        Meal burger = factory.createMeal();

        // Wrap with decorators
        MealComponent deluxeBurger = new ExtraCheeseDecorator(burger);
        deluxeBurger = new BaconDecorator(deluxeBurger);

        deluxeBurger.prepare();
        deluxeBurger.serve();
        deluxeBurger.displayInfo();
        orderSystem.placeOrder((Meal) burger); // Place original for tracking
    }

    public void orderPizzaWithDiscount(double discountPercent) {
        System.out.println("\n--- Ordering Pizza with Special Discount ---");
        MealFactory factory = new ItalianMealFactory("pizza");
        Meal pizza = factory.createMeal();

        MealComponent discountedPizza = new DiscountDecorator(pizza, discountPercent);

        discountedPizza.prepare();
        discountedPizza.serve();
        discountedPizza.displayInfo();
        orderSystem.placeOrder(pizza);
    }

    // Composite-based orders (Combos)
    public void orderFamilyCombo() {
        System.out.println("\n--- Ordering Family Combo ---");

        // Create individual items
        MealFactory italianFactory = new ItalianMealFactory("pizza");
        MealFactory americanFactory = new AmericanMealFactory();
        MealFactory healthyFactory = new HealthyMealFactory();

        Meal pizza1 = italianFactory.createMeal();
        Meal pizza2 = italianFactory.createMeal();
        Meal burger = americanFactory.createMeal();
        Meal salad = healthyFactory.createMeal();

        // Create combo with 15% discount
        MealCombo familyCombo = new MealCombo("Family Combo", 15.0);
        familyCombo.add(pizza1);
        familyCombo.add(pizza2);
        familyCombo.add(burger);
        familyCombo.add(salad);

        familyCombo.prepare();
        familyCombo.serve();
        familyCombo.displayInfo();

        // Track combo as single order
        orderSystem.placeOrder(new ComboMeal(familyCombo));
    }

    public void orderKidsCombo() {
        System.out.println("\n--- Ordering Kids Combo ---");

        MealFactory factory = new AmericanMealFactory();
        Meal burger = factory.createMeal();

        MealCombo kidsCombo = new MealCombo("Kids Combo", 10.0);
        kidsCombo.add(burger);

        kidsCombo.prepare();
        kidsCombo.serve();
        kidsCombo.displayInfo();

        orderSystem.placeOrder(new ComboMeal(kidsCombo));
    }

    // Order history and stats
    public void displayOrderHistory() {
        orderSystem.displayOrderHistory();
    }

    public void displayStatistics() {
        System.out.println("\n========================================");
        System.out.println("📊 RESTAURANT STATISTICS");
        System.out.println("========================================");
        System.out.println("Total Orders: " + orderSystem.getTotalOrders());
        System.out.println("Total Revenue: $" + String.format("%.2f", orderSystem.getTotalRevenue()));
        System.out.println("========================================\n");
    }
}
