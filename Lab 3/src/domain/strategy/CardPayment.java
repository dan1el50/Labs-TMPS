package domain.strategy;

public class CardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CardPayment(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("   Card Holder: " + cardHolder);
        System.out.println("   Amount: $" + String.format("%.2f", amount));
    }
}