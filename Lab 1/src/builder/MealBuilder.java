package builder;

import models.Meal;

public interface MealBuilder {
    MealBuilder setBase(String base);
    MealBuilder addProtein(String protein);
    MealBuilder addVegetables(String vegetables);
    MealBuilder addSauce(String sauce);
    MealBuilder addToppings(String toppings);
    MealBuilder addSides(String sides);
    Meal build();
}
