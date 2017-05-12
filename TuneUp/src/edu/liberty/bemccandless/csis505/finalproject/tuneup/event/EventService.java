package edu.liberty.bemccandless.csis505.finalproject.tuneup.event;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.config.DbConfig;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceType;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public ResultSet getAllEventsForVehicle(Vehicle vehicle) throws SQLException {
        String selectAllEventsSql = 
                "select * from tuneup.events "
                + " where vehicle_id=?"
                + " order by estimated_maintenance_date desc";
        
        PreparedStatement selectAllEventsStatement = DbConfig.getDbConnection().prepareStatement(selectAllEventsSql);
        selectAllEventsStatement.setInt(1, vehicle.getId());
        
        return selectAllEventsStatement.executeQuery();
    }

}
