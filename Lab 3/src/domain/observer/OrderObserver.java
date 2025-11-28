package domain.observer;
import domain.composite.MealComponent;

public interface OrderObserver {
    void update(MealComponent order);
}