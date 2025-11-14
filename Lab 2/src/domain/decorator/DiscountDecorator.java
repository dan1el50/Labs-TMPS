package domain.decorator;

import domain.composite.MealComponent;

public class DiscountDecorator extends MealDecorator {
    private double discountPercent;

    public DiscountDecorator(MealComponent meal, double discountPercent) {
        super(meal);
        this.discountPercent = discountPercent;
    }

    @Override
    public String getName() {
        return wrappedMeal.getName() + " (" + discountPercent + "% OFF)";
    }

    @Override
    public double getPrice() {
        return wrappedMeal.getPrice() * (1 - discountPercent / 100);
    }

    @Override
    public void displayInfo() {
        System.out.println("🎉 SPECIAL DISCOUNT APPLIED!");
        wrappedMeal.displayInfo();
        System.out.println("Original Price: $" + String.format("%.2f", wrappedMeal.getPrice()));
        System.out.println("Discount: " + discountPercent + "%");
        System.out.println("Final Price: $" + String.format("%.2f", getPrice()));
    }
}
