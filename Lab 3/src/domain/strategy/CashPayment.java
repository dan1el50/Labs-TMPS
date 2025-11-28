package domain.strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + String.format("%.2f", amount) + " in Cash.");
    }
}