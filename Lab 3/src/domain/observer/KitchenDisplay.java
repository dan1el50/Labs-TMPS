package domain.observer;

import domain.composite.MealComponent;

public class KitchenDisplay implements OrderObserver {
    @Override
    public void update(MealComponent order) {
        System.out.println("[KITCHEN ALERT] New Order Received: " + order.getName());
        System.out.println("Preparation started immediately.");
    }
}