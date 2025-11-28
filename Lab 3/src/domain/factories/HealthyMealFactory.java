package domain.factories;

import domain.models.Meal;
import domain.models.Salad;

public class HealthyMealFactory extends MealFactory {

    @Override
    public Meal createMeal() {
        return new Salad();
    }
}
