package domain.builder;

import domain.models.Meal;
import domain.models.Pizza;

public class PizzaBuilder implements MealBuilder {

    private Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public MealBuilder setBase(String base) {
        pizza.setBase(base);
        return this;
    }

    @Override
    public MealBuilder addProtein(String protein) {
        pizza.setProtein(protein);
        return this;
    }

    @Override
    public MealBuilder addVegetables(String vegetables) {
        pizza.setVegetables(vegetables);
        return this;
    }

    @Override
    public MealBuilder addSauce(String sauce) {
        pizza.setSauce(sauce);
        return this;
    }

    @Override
    public MealBuilder addToppings(String toppings) {
        pizza.setToppings(toppings);
        return this;
    }

    @Override
    public MealBuilder addSides(String sides) {
        pizza.setSides(sides);
        return this;
    }

    @Override
    public Meal build() {
        return pizza;
    }
}
