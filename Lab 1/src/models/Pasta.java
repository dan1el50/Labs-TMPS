package models;

public class Pasta extends Meal {

    public Pasta() {
        this.name = "Pasta";
        this.price = 14.99;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing the ordered pasta...");
    }

    @Override
    public void serve() {
        System.out.println("Serving the pasta!");
    }
}
