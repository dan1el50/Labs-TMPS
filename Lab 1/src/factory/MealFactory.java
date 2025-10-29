package factory;

import models.Meal;

public abstract class MealFactory {

    // Factory Method
    public abstract Meal createMeal();

    // Template method that uses the factory method
    public Meal orderMeal() {
        Meal meal = createMeal();
        meal.prepare();
        meal.serve();
        return meal;
    }
}
