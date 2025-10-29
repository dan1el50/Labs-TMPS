package builder;

import models.Meal;
import models.Burger;

public class BurgerBuilder implements MealBuilder {

    private Burger burger;

    public BurgerBuilder() {
        this.burger = new Burger();
    }

    @Override
    public MealBuilder setBase(String base) {
        burger.setBase(base);
        return this;
    }

    @Override
    public MealBuilder addProtein(String protein) {
        burger.setProtein(protein);
        return this;
    }

    @Override
    public MealBuilder addVegetables(String vegetables) {
        burger.setVegetables(vegetables);
        return this;
    }

    @Override
    public MealBuilder addSauce(String sauce) {
        burger.setSauce(sauce);
        return this;
    }

    @Override
    public MealBuilder addToppings(String toppings) {
        burger.setToppings(toppings);
        return this;
    }

    @Override
    public MealBuilder addSides(String sides) {
        burger.setSides(sides);
        return this;
    }

    @Override
    public Meal build() {
        return burger;
    }
}
