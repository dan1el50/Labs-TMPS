// client/Main.java
package client;

import domain.facade.RestaurantFacade;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  WELCOME TO RESTAURANT ORDERING SYSTEM ║");
        System.out.println("╔════════════════════════════════════════╗\n");

        // Create facade - single point of interaction
        RestaurantFacade restaurant = new RestaurantFacade();

        // Simple orders
        restaurant.orderPizza();
        restaurant.orderBurger();

        // Custom builder order
        restaurant.orderCustomBurger("Sesame Bun", "Beef Patty", "Lettuce, Tomato, Onion");

        // Decorated orders
        restaurant.orderBurgerWithExtras();
        restaurant.orderPizzaWithDiscount(20.0);

        // Composite orders (Combos)
        restaurant.orderFamilyCombo();
        restaurant.orderKidsCombo();

        // Display results
        restaurant.displayOrderHistory();
        restaurant.displayStatistics();

        System.out.println("\n🎉 Thank you for using our system!");
    }
}
