package repository;

import models.Vehicle;
import java.util.List;

// DIP: Interface (abstraction) that high-level modules depend on
public interface IVehicleRepository {
    void addVehicle(Vehicle vehicle);
    Vehicle getVehicleById(String id);
    List<Vehicle> getAllVehicles();
    List<Vehicle> getAvailableVehicles();
}
