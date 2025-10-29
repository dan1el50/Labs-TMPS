import models.Meal;
import factory.*;
import builder.*;
import singleton.RestaurantOrderSystem;

public class Main {

    public static void main(String[] args) {

        // Get Singleton instance
        RestaurantOrderSystem orderSystem = RestaurantOrderSystem.getInstance();
        System.out.println("WELCOME TO THE RESTAURANT ORDERING SYSTEM");

        // Italian cuisine
        MealFactory italianFactory = new ItalianMealFactory("pizza");
        Meal pizza = italianFactory.orderMeal();
        orderSystem.placeOrder(pizza);

        // Healthy cuisine
        MealFactory healthyFactory = new HealthyMealFactory();
        Meal salad = healthyFactory.orderMeal();
        orderSystem.placeOrder(salad);

        // Custom Pizza using Builder
        System.out.println("Building custom Margherita Pizza...");
        Meal customPizza = new PizzaBuilder()
                .setBase("Thin Crust")
                .addSauce("Tomato Sauce")
                .addToppings("Mozzarella, Basil, Olive Oil")
                .addSides("Garlic Bread")
                .build();
        customPizza.prepare();
        customPizza.serve();
        customPizza.displayInfo();
        orderSystem.placeOrder(customPizza);

        // Custom Burger using Builder
        System.out.println("Building custom Double Cheeseburger...");
        Meal customBurger = new BurgerBuilder()
                .setBase("Sesame Bun")
                .addProtein("Double Beef Patty")
                .addVegetables("Lettuce, Tomato, Onion, Pickles")
                .addSauce("Special Sauce")
                .addToppings("Cheddar Cheese, Bacon")
                .addSides("French Fries, Coleslaw")
                .build();
        customBurger.prepare();
        customBurger.serve();
        customBurger.displayInfo();
        orderSystem.placeOrder(customBurger);

        // Display order history
        orderSystem.displayOrderHistory();

        // Verify Singleton - both references point to same instance
        RestaurantOrderSystem anotherReference = RestaurantOrderSystem.getInstance();
        System.out.println("Singleton verification:");
        System.out.println("Same instance? " + (orderSystem == anotherReference));
        System.out.println("Total orders from another reference: " +
                anotherReference.getTotalOrders());
    }
}
