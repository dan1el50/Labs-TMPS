package repository;

import models.Vehicle;
import java.util.*;

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
