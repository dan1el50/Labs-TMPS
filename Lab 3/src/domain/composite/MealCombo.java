package domain.composite;
import java.util.ArrayList;
import java.util.List;

public class MealCombo implements MealComponent {
    private String name;
    private List<MealComponent> items;
    private double discount;

    public MealCombo(String name, double discount) {
        this.name = name;
        this.discount = discount;
        this.items = new ArrayList<>();
    }

    public MealCombo(String name) {
        this(name, 0.0);
    }

    public void add(MealComponent item) {
        items.add(item);
    }

    public void remove(MealComponent item) {
        items.remove(item);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double total = 0.0;
        for (MealComponent item : items) {
            total += item.getPrice();
        }
        return total * (1 - discount / 100);
    }

    @Override
    public void displayInfo() {
        System.out.println("Combo: " + name.toUpperCase());
        System.out.println("Contains " + items.size() + " items:");

        double subtotal = 0.0;
        for (int i = 0; i < items.size(); i++) {
            MealComponent item = items.get(i);
            System.out.println(item.getName() + item.getPrice());
            subtotal += item.getPrice();
        }

        System.out.println("----------------------------------------");
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        if (discount > 0) {
            System.out.println("Combo Discount: " + discount + "%");
            System.out.println("You Save: $" + String.format("%.2f", subtotal - getPrice()));
        }
        System.out.println("TOTAL: $" + String.format("%.2f", getPrice()));
        System.out.println("========================================\n");
    }

    @Override
    public void prepare() {
        System.out.println("Preparing: " + name);
        for (MealComponent item : items) {
            item.prepare();
        }
    }

    @Override
    public void serve() {
        System.out.println("Serving: " + name);
        for (MealComponent item : items) {
            item.serve();
        }
    }
}
