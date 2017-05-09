package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

import java.sql.SQLException;

/**
 *
 * @author bemccandless
 */
public class VehicleController {
    
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    
    public void addVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.addVehicle(vehicle);
    }
    
    public void editVehicle(Vehicle vehicle) {
        
    }
    
    public void deleteVehicle(Vehicle vehicle) {
        
    }
    
}
