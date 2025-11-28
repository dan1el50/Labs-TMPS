package domain.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {
    private List<Command> orderPad = new ArrayList<>();

    public void takeOrder(Command command) {
        System.out.println("Waiter notes down the order...");
        orderPad.add(command);
    }

    public void sendOrdersToKitchen() {
        System.out.println("\nWaiter sends all orders to kitchen:");
        for (Command command : orderPad) {
            command.execute();
        }
        orderPad.clear();
    }
}