package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

import java.sql.SQLException;
import javax.swing.ListModel;

/**
 *
 * @author bemccandless
 */
public class VehicleController {
    
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    
    public ListModel<Vehicle> getAllVehicles() throws SQLException {
        return vehicleService.getAllVehicles();
    }
    
    public void addVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.addVehicle(vehicle);
    }
    
    public void editVehicle(Vehicle vehicle) {
        
    }
    
    public void deleteVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.deleteVehicle(vehicle);
    }
    
}
