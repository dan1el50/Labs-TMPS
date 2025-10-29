package models;

public class Salad extends Meal {

    public Salad() {
        this.name = "Salad";
        this.price = 8.99;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing teh ordered salad...");
    }

    @Override
    public void serve() {
        System.out.println("Serving the salad!");
    }
}
