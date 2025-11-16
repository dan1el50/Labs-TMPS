// client/Main.java

package client;

import domain.facade.RestaurantFacade;

public class Main {
    public static void main(String[] args) {
        // FACADE PATTERN - Single point of interaction
        RestaurantFacade restaurant = new RestaurantFacade();

        System.out.println("═══════════════════════════════════════");
        System.out.println("    DECORATOR PATTERN DEMONSTRATION");
        System.out.println("═══════════════════════════════════════\n");

        // DECORATOR PATTERN - Adding extras dynamically
        restaurant.orderBurgerWithExtras();

        // DECORATOR PATTERN - Applying discount
        restaurant.orderPizzaWithDiscount(20.0);

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("    COMPOSITE PATTERN DEMONSTRATION");
        System.out.println("═══════════════════════════════════════\n");

        // COMPOSITE PATTERN - Family combo (multiple meals)
        restaurant.orderFamilyCombo();

        // COMPOSITE PATTERN - Kids combo (smaller combo)
        restaurant.orderKidsCombo();

        System.out.println("\n═══════════════════════════════════════");
        System.out.println("         ORDER SUMMARY (FACADE)");
        System.out.println("═══════════════════════════════════════\n");

        // FACADE PATTERN - Simplified access to order history and statistics
        restaurant.displayOrderHistory();
        restaurant.displayStatistics();

        System.out.println("\n🎉 Structural Patterns Demo Complete!");
    }
}
