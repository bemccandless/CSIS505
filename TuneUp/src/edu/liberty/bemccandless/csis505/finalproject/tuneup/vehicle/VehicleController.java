package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.event.EventService;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceService;
import java.sql.SQLException;
import javax.swing.ListModel;

/**
 * Maintains a level of control between the data layer and the view layer for Vehicles.
 * 
 * @author bemccandless
 */
public class VehicleController {
    
    private final VehicleService vehicleService;
    private final MaintenanceService maintenanceService;
    private final EventService eventService;

    public VehicleController(VehicleService vehicleService, MaintenanceService maintenanceService, EventService eventService) {
        this.vehicleService = vehicleService;
        this.maintenanceService = maintenanceService;
        this.eventService = eventService;
    }
    
    /**
     * Get all vehicles.
     * 
     * @return
     * @throws SQLException 
     */
    public ListModel<Vehicle> getAllVehicles() throws SQLException {
        return vehicleService.getAllVehicles();
    }
    
    /**
     * Add a vehicle.
     * 
     * @param vehicle
     * @throws SQLException 
     */
    public void addVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.addVehicle(vehicle);
    }
    
    /**
     * Edit a vehicle.
     * 
     * @param vehicle
     * @throws SQLException 
     */
    public void editVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.editVehicle(vehicle);
    }
    
    /**
     * Delete a vehicle.
     * 
     * @param vehicle
     * @throws SQLException 
     */
    public void deleteVehicle(Vehicle vehicle) throws SQLException {
        eventService.deleteEventsForVehicle(vehicle);
        maintenanceService.deleteMaintenanceItemsForVehicle(vehicle);
        vehicleService.deleteVehicle(vehicle);
    }
    
}
