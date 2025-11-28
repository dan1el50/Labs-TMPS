package utilities;

import domain.composite.MealComponent;
import domain.observer.OrderObserver;
import domain.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrderSystem {

    // Static instance variable
    private static RestaurantOrderSystem instance;

    // Order management - Updated to use MealComponent to support Decorators/Combos
    private List<MealComponent> orderHistory;
    private int totalOrders;
    private double totalRevenue;

    // OBSERVER PATTERN: List of subscribers (Kitchen, Accounting, etc.)
    private List<OrderObserver> observers;

    // Private constructor
    private RestaurantOrderSystem() {
        this.orderHistory = new ArrayList<>();
        this.observers = new ArrayList<>();
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

    // OBSERVER PATTERN: Attach a new observer
    public void attach(OrderObserver observer) {
        observers.add(observer);
    }

    // OBSERVER PATTERN: Notify all observers when an order is placed
    private void notifyObservers(MealComponent meal) {
        for (OrderObserver observer : observers) {
            observer.update(meal);
        }
    }

    // STRATEGY PATTERN: Process payment using a supplied strategy
    public void processPayment(PaymentStrategy strategy) {
        System.out.println("\n--- Processing Payment ---");
        // Pass the total calculated revenue to the payment strategy
        strategy.pay(this.totalRevenue);
        System.out.println("--------------------------");
    }

    // Place an order - Accepts MealComponent to handle both simple Meals and Decorated Meals
    public void placeOrder(MealComponent meal) {
        orderHistory.add(meal);
        totalOrders++;
        totalRevenue += meal.getPrice();

        System.out.println("Order #" + totalOrders + " placed: " + meal.getName());

        // Notify the kitchen/displays (Observer Pattern)
        notifyObservers(meal);

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
                        " - $" + String.format("%.2f", orderHistory.get(i).getPrice()));
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