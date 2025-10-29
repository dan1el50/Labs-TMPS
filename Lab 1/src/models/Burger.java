package models;

public class Burger extends Meal {

    public Burger() {
        this.name = "Burger";
        this.price = 10.99;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing the ordered burger...");
    }

    @Override
    public void serve() {
        System.out.println("Serving the burger!");
    }
}
