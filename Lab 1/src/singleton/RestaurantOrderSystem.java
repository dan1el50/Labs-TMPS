package utilities;

import domain.models.Meal;
import java.util.ArrayList;
import java.util.List;

public class RestaurantOrderSystem {

    // Static instance variable
    private static RestaurantOrderSystem instance;

    // Order management
    private List<Meal> orderHistory;
    private int totalOrders;
    private double totalRevenue;

    // Private constructor
    private RestaurantOrderSystem() {
        this.orderHistory = new ArrayList<>();
        this.totalOrders = 0;
        this.totalRevenue = 0.0;
    }

    // Static method to get the single instance
    public static RestaurantOrderSystem getInstance() {
        if (instance == null) {
            instance = new RestaurantOrderSystem();
        }
        return instance;
    }

    // Place an order
    public void placeOrder(Meal meal) {
        orderHistory.add(meal);
        totalOrders++;
        totalRevenue += meal.getPrice();
        System.out.println("Order #" + totalOrders + " placed: " + meal.getName());
        System.out.println("===============");
    }

    // Get order history
    public void displayOrderHistory() {
        System.out.println("ORDER HISTORY");
        if (orderHistory.isEmpty()) {
            System.out.println("No orders yet!");
        } else {
            for (int i = 0; i < orderHistory.size(); i++) {
                System.out.println((i + 1) + ". " + orderHistory.get(i).getName() +
                        " - $" + orderHistory.get(i).getPrice());
            }
        }
        System.out.println("===============");
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}
