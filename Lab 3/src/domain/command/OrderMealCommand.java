package domain.command;
import domain.composite.MealComponent;
import utilities.RestaurantOrderSystem;

public class OrderMealCommand implements Command {
    private MealComponent meal;

    public OrderMealCommand(MealComponent meal) {
        this.meal = meal;
    }

    @Override
    public void execute() {
        RestaurantOrderSystem.getInstance().placeOrder(meal);
    }
}