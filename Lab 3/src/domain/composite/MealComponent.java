package domain.composite;

public interface MealComponent {
    String getName();
    double getPrice();
    void displayInfo();
    void prepare();
    void serve();
}
