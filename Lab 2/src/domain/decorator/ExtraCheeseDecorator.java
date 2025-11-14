package domain.decorator;

import domain.composite.MealComponent;

public class ExtraCheeseDecorator extends MealDecorator {
    private static final double EXTRA_COST = 1.50;

    public ExtraCheeseDecorator(MealComponent meal) {
        super(meal);
    }

    @Override
    public String getName() {
        return wrappedMeal.getName() + " + Extra Cheese";
    }

    @Override
    public double getPrice() {
        return wrappedMeal.getPrice() + EXTRA_COST;
    }

    @Override
    public void prepare() {
        wrappedMeal.prepare();
        System.out.println("Adding extra cheese...");
    }
}
