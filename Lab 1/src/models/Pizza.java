package models;

public class Pizza extends Meal {

    public Pizza() {
        this.name = "Pizza";
        this.price = 12.99;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing the ordered pizza...");
    }

    @Override
    public void serve() {
        System.out.println("Serving the hot pizza!");
    }
}
