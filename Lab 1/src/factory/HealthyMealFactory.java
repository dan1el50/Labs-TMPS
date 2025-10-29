package factory;

import models.Meal;
import models.Salad;

public class HealthyMealFactory extends MealFactory {

    @Override
    public Meal createMeal() {
        return new Salad();
    }
}
