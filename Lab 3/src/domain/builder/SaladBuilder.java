package domain.builder;

import domain.models.Meal;
import domain.models.Salad;

public class SaladBuilder implements MealBuilder {

    private Salad salad;

    public SaladBuilder() {
        this.salad = new Salad();
    }

    @Override
    public MealBuilder setBase(String base) {
        salad.setBase(base);
        return this;
    }

    @Override
    public MealBuilder addProtein(String protein) {
        salad.setProtein(protein);
        return this;
    }

    @Override
    public MealBuilder addVegetables(String vegetables) {
        salad.setVegetables(vegetables);
        return this;
    }

    @Override
    public MealBuilder addSauce(String sauce) {
        salad.setSauce(sauce);
        return this;
    }

    @Override
    public MealBuilder addToppings(String toppings) {
        salad.setToppings(toppings);
        return this;
    }

    @Override
    public MealBuilder addSides(String sides) {
        salad.setSides(sides);
        return this;
    }

    @Override
    public Meal build() {
        return salad;
    }
}
