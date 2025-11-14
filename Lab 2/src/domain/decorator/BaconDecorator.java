package domain.decorator;

import domain.composite.MealComponent;

public class BaconDecorator extends MealDecorator {
    private static final double EXTRA_COST = 2.50;

    public BaconDecorator(MealComponent meal) {
        super(meal);
    }

    @Override
    public String getName() {
        return wrappedMeal.getName() + " + Bacon";
    }

    @Override
    public double getPrice() {
        return wrappedMeal.getPrice() + EXTRA_COST;
    }

    @Override
    public void prepare() {
        wrappedMeal.prepare();
        System.out.println("Adding crispy bacon...");
    }
}
