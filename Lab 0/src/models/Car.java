package models;

public class Car extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public Car(String id, String brand) {
        super(id, brand);
    }

    @Override
    public double calculateRentalCost(int days) {
        return DAILY_RATE * days;
    }
}
