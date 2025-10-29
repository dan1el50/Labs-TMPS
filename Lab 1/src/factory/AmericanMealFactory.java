package factory;

import models.Meal;
import models.Burger;

public class AmericanMealFactory extends MealFactory {

    @Override
    public Meal createMeal() {
        return new Burger();
    }
}
