# SOLID Principles

## Purpose
This report explores the implementation of three SOLID principles—Single Responsibility, Open/Closed, and Dependency Inversion—in a vehicle rental system built with Java. The goal is to demonstrate how SOLID helps structure maintainable and extensible software for real-world applications.
## What is SOLID?
**SOLID** is an acronym for five design principles that improve software structure and maintainability:

- **S**ingle Responsibility Principle (SRP): Each class should have one job.
- **O**pen/Closed Principle (OCP): Classes should be open for extension but closed for modification.
- **L**iskov Substitution Principle (LSP): Subtypes should replace the supertype without changing behavior.
- **I**nterface Segregation Principle (ISP): Don't force clients to depend on methods they don't use.
- **D**ependency Inversion Principle (DIP): Depend on abstractions, not concrete classes.

## Idea
This project implements a vehicle rental system that handles different types of vehicles (cars and motorcycles), rental operations, cost calculations, and vehicle availability tracking. Each SOLID principle is represented by specific parts of the design to show the benefits of separation, extensibility, and abstraction in managing rental operations.
***

## Principles Implemented

### 1. Single Responsibility Principle (SRP)
**What it means:** Each class should do only one thing.

**Implementation:**
- The Vehicle class is responsible only for storing vehicle data and defining the rental cost calculation contract. 
- The VehicleRepository class handles vehicle storage operations exclusively. 
- The RentalService class focuses solely on rental operations (renting, returning, displaying vehicles). 
- Each class has a single, well-defined responsibility, making the code more modular and easier to maintain.

**Code Snippet:**
```
public class RentalService {
    private IVehicleRepository repository;

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
            System.out.println("Days: " + days);
            System.out.printf("Total Cost: $%.2f\n", cost);
            return true;
        }
        return false;
    }
    public void showAvailableVehicles() {
        for (Vehicle v : repository.getAvailableVehicles()) {
            System.out.println(v.getId() + " - " + v.getBrand());
        }
    }
}
```

***

### 2. Open/Closed Principle (OCP)
**What it means:** Classes can be extended, but their source code shouldn't need to be changed.

**Implementation:**
- The Vehicle abstract class allows new vehicle types to be added without modifying existing code. 
- Different vehicle types (Car, Motorcycle) can have different rental pricing strategies by extending the base Vehicle class. 
- New vehicle types (like Truck, Bicycle, or Van) can be added in the future by simply extending Vehicle without touching existing code.
- 
**Code Snippet:**
```
public abstract class Vehicle {
    private String id;
    private String brand;
    private boolean isAvailable;

    public Vehicle(String id, String brand) {
        this.id = id;
        this.brand = brand;
        this.isAvailable = true;
    }
    public abstract double calculateRentalCost(int days);

    public String getId() { return id; }
    public String getBrand() { return brand; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}

// Extending Vehicle without modifying it
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

```

***

### 3. Dependency Inversion Principle (DIP)
**What it means:** Depend on interfaces or abstractions, not concrete implementations.

**Implementation:**
- RentalService depends on the IVehicleRepository interface, not on the specific VehicleRepository implementation. 
- The repository interface acts as an abstraction layer between the service and data storage. 
- Dependencies are injected through the constructor, allowing different implementations to be substituted without changing RentalService. 
- This allows swapping from in-memory storage to database storage without modifying the service layer.

**Code Snippet:**
```
// DIP: Interface (abstraction) that high-level modules depend on
public interface IVehicleRepository {
    void addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(String id);
    List<Vehicle> getAllVehicles();
    List<Vehicle> getAvailableVehicles();
}

public class VehicleRepository implements IVehicleRepository {
    private Map<String, Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new HashMap<>();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getId(), vehicle);
    }

    @Override
    public Vehicle getVehicleById(String id) {
        return vehicles.get(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicles.values());
    }

    @Override
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> available = new ArrayList<>();
        for (Vehicle v : vehicles.values()) {
            if (v.isAvailable()) {
                available.add(v);
            }
        }
        return available;
    }
}
```

***

## Conclusion
By following SOLID principles in this vehicle rental system, the code becomes easier to maintain, extend, and test. New vehicle types can be added without modifying existing code, repository implementations can be swapped (from in-memory to database), and rental operations remain isolated from storage concerns. Applying even just a few SOLID principles in software design helps keep the codebase robust, flexible, and clean, reducing technical debt and improving long-term maintainability.