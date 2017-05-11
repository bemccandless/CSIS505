package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author bemccandless
 */
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }
    
    public void addMaintenanceItem(Vehicle vehicle, MaintenanceType maintenanceType, int serviceMileage, Date serviceDate, double price) throws SQLException {
        MaintenanceItem maintenanceItem = new MaintenanceItem(
                maintenanceType, serviceMileage, serviceDate, price);
        
        maintenanceService.addMaintenanceItem(vehicle, maintenanceItem);
    }
    
}
