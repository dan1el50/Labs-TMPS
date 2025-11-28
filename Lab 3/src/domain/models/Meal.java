package domain.models;
import domain.composite.MealComponent;

public abstract class Meal implements MealComponent {
    protected String name;
    protected double price;
    protected String base;
    protected String protein;
    protected String vegetables;
    protected String sauce;
    protected String toppings;
    protected String sides;

    @Override
    public abstract void prepare();

    @Override
    public abstract void serve();

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() { return price; }

    public void setBase(String base) { this.base = base; }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public void setVegetables(String vegetables) {
        this.vegetables = vegetables;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + "Custom" + name + " ===");
        System.out.println("Price: $" + price);
        if (base != null) System.out.println("Base: " + base);
        if (protein != null) System.out.println("Protein: " + protein);
        if (vegetables != null) System.out.println("Vegetables: " + vegetables);
        if (sauce != null) System.out.println("Sauce: " + sauce);
        if (toppings != null) System.out.println("Toppings: " + toppings);
        if (sides != null) System.out.println("Sides: " + sides);
    }
}
