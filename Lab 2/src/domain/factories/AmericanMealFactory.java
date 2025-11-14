package domain.factories;

import domain.models.Meal;
import domain.models.Burger;

public class AmericanMealFactory extends MealFactory {

    @Override
    public Meal createMeal() {
        return new Burger();
    }
}
