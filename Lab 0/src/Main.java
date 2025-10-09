import models.*;
import repository.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== VEHICLE RENTAL SYSTEM ===\n");

        // DIP: Using interface instead of concrete class
        IVehicleRepository repository = new VehicleRepository();

        // OCP: Adding different vehicle types without modifying existing code
        repository.addVehicle(new Car("C001", "Toyota Camry"));
        repository.addVehicle(new Car("C002", "BMW X5"));
        repository.addVehicle(new Motorcycle("M001", "Harley Davidson"));
        repository.addVehicle(new Motorcycle("M002", "Honda CBR"));

        // SRP: Service handles only rental operations
        RentalService rentalService = new RentalService(repository);

        // Show all vehicles
        rentalService.showAllVehicles();

        // Show available vehicles
        rentalService.showAvailableVehicles();

        // Rent a car for 5 days
        rentalService.rentVehicle("C001", 5);

        // Rent a motorcycle for 3 days
        rentalService.rentVehicle("M001", 3);

        // Show updated availability
        rentalService.showAllVehicles();

        // Return a vehicle
        System.out.println("\n=== RETURNING VEHICLE ===");
        rentalService.returnVehicle("C001");

        // Show final state
        rentalService.showAllVehicles();
    }
}
