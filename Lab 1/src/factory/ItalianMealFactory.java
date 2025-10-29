package factory;

import models.Meal;
import models.Pizza;
import models.Pasta;

public class ItalianMealFactory extends MealFactory {

    private String mealType;

    public ItalianMealFactory(String mealType) {
        this.mealType = mealType;
    }

    @Override
    public Meal createMeal() {
        if (mealType.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else if (mealType.equalsIgnoreCase("pasta")) {
            return new Pasta();
        }
        return null;
    }
}
