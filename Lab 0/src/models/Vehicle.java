package models;

public abstract class Vehicle {
    private String id;
    private String brand;
    private boolean isAvailable;

    public Vehicle(String id, String brand) {
        this.id = id;
        this.brand = brand;
        this.isAvailable = true;
    }

    // OCP: Each vehicle type implements its own pricing
    public abstract double calculateRentalCost(int days);

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}
