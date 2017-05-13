package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.event.EventService;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceService;
import java.sql.SQLException;
import javax.swing.ListModel;

/**
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
    
    public ListModel<Vehicle> getAllVehicles() throws SQLException {
        return vehicleService.getAllVehicles();
    }
    
    public void addVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.addVehicle(vehicle);
    }
    
    public void editVehicle(Vehicle vehicle) throws SQLException {
        vehicleService.editVehicle(vehicle);
    }
    
    public void deleteVehicle(Vehicle vehicle) throws SQLException {
        eventService.deleteEventsForVehicle(vehicle);
        maintenanceService.deleteMaintenanceItemsForVehicle(vehicle);
        vehicleService.deleteVehicle(vehicle);
    }
    
}
