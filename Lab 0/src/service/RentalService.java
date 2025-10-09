package service;

import models.Vehicle;
import repository.IVehicleRepository;

// SRP: This class only handles rental operations
public class RentalService {
    private IVehicleRepository repository;

    // DIP: Depends on interface, not concrete implementation
    public RentalService(IVehicleRepository repository) {
        this.repository = repository;
    }

    public boolean rentVehicle(String vehicleId, int days) {
        Vehicle vehicle = repository.getVehicleById(vehicleId);
        if (vehicle != null && vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            double cost = vehicle.calculateRentalCost(days);
            System.out.println("\n=== RENTAL SUCCESSFUL ===");
            System.out.println("Vehicle: " + vehicle.getBrand());
            System.out.println("ID: " + vehicleId);
            System.out.println("Days: " + days);
            System.out.printf("Total Cost: $%.2f\n", cost);
            System.out.println("========================\n");
            return true;
        }
        System.out.println("Vehicle not available!");
        return false;
    }

    public boolean returnVehicle(String vehicleId) {
        Vehicle vehicle = repository.getVehicleById(vehicleId);
        if (vehicle != null && !vehicle.isAvailable()) {
            vehicle.setAvailable(true);
            System.out.println("Vehicle " + vehicleId + " returned successfully!");
            return true;
        }
        return false;
    }

    public void showAvailableVehicles() {
        System.out.println("\n=== AVAILABLE VEHICLES ===");
        for (Vehicle v : repository.getAvailableVehicles()) {
            System.out.println(v.getId() + " - " + v.getBrand());
        }
        System.out.println("==========================\n");
    }

    public void showAllVehicles() {
        System.out.println("\n=== ALL VEHICLES ===");
        for (Vehicle v : repository.getAllVehicles()) {
            String status = v.isAvailable() ? "Available" : "Rented";
            System.out.println(v.getId() + " - " + v.getBrand() + " [" + status + "]");
        }
        System.out.println("====================\n");
    }
}
