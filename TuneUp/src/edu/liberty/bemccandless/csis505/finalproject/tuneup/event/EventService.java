package edu.liberty.bemccandless.csis505.finalproject.tuneup.event;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceType;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author bemccandless
 */
public class EventService {
    
    public Date calculateEstimatedMaintenanceDate(Date lastServiceDate, MaintenanceType maintenanceType) {
        return new Date(LocalDate.now().plus(maintenanceType.getTimeBetweenService()).toEpochDay());
    }
    
    public int calculateEstimatedMaintenanceMileage(int currentMilage, MaintenanceType maintenanceType) {
        return maintenanceType.calculateNextServiceMileage(currentMilage);
    }

}
