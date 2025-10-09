package models;

public class Motorcycle extends Vehicle {
    private static final double DAILY_RATE = 30.0;

    public Motorcycle(String id, String brand) {
        super(id, brand);
    }

    @Override
    public double calculateRentalCost(int days) {
        return DAILY_RATE * days;
    }
}
