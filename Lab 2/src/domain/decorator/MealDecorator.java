package domain.decorator;

import domain.composite.MealComponent;

public abstract class MealDecorator implements MealComponent {
    protected MealComponent wrappedMeal;

    public MealDecorator(MealComponent meal) {
        this.wrappedMeal = meal;
    }

    @Override
    public String getName() {
        return wrappedMeal.getName();
    }

    @Override
    public double getPrice() {
        return wrappedMeal.getPrice();
    }

    @Override
    public void displayInfo() {
        wrappedMeal.displayInfo();
    }

    @Override
    public void prepare() {
        wrappedMeal.prepare();
    }

    @Override
    public void serve() {
        wrappedMeal.serve();
    }
}
