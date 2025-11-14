package domain.models;

import domain.composite.MealCombo;

public class ComboMeal extends Meal {
    private MealCombo combo;

    public ComboMeal(MealCombo combo) {
        this.combo = combo;
        this.name = combo.getName();
        this.price = combo.getPrice();
    }

    @Override
    public void prepare() {
        combo.prepare();
    }

    @Override
    public void serve() {
        combo.serve();
    }

    @Override
    public void displayInfo() {
        combo.displayInfo();
    }
}
