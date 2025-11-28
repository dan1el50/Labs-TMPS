package domain.factories;

import domain.models.Burger;
import domain.models.Meal;

public class AmericanMealFactory extends MealFactory {

    @Override
    public Meal createMeal() {
        return new Burger();
    }
}
