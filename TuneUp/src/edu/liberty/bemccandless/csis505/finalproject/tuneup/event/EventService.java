package edu.liberty.bemccandless.csis505.finalproject.tuneup.event;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.config.DbConfig;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.MaintenanceType;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bemccandless
 */
public class EventService {
    
    public Date calculateEstimatedMaintenanceDate(Date lastServiceDate, MaintenanceType maintenanceType) {
//        return new Date(LocalDate.now().plus(maintenanceType.getTimeBetweenService()).toEpochDay());
        return maintenanceType.calculateNextServiceDate(lastServiceDate);
    }
    
    public int calculateEstimatedMaintenanceMileage(int currentMilage, MaintenanceType maintenanceType) {
        return maintenanceType.calculateNextServiceMileage(currentMilage);
    }
    
    public ResultSet getAllEvents() throws SQLException {
        String selectAllEventsSql = 
                "select * from tuneup.events order by estimated_maintenance_date";
        
        PreparedStatement selectAllEventsStatement = DbConfig.getDbConnection().prepareStatement(selectAllEventsSql);
        
        return selectAllEventsStatement.executeQuery();
    }
    
    public void addEvent(Event event) throws SQLException {
        String insertEventSql = "insert into events (vehicle_id, maintenance_item_id, estimated_maintenance_date, recommended_mileage) values (?, ?, ?, ?)";
        
        PreparedStatement insertEventStatement = DbConfig.getDbConnection().prepareStatement(insertEventSql, Statement.RETURN_GENERATED_KEYS);
        insertEventStatement.setInt(1, event.getVehicle().getId());
        insertEventStatement.setInt(2, event.getMaintenanceItem().getId());
        insertEventStatement.setDate(3, event.getEstimatedMaintenanceDate());
        insertEventStatement.setInt(4, event.getRecommendedMileage());
        
        insertEventStatement.executeUpdate();
        
        ResultSet generatedKey = insertEventStatement.getGeneratedKeys();
        if (generatedKey.next()) {
            event.setId(generatedKey.getInt(1));
        }
    }
    
    public void deleteEventsForMaintenanceItem(int maintenanceItemId) throws SQLException {
        String deleteEventsForMaintenanceItemSql = "delete from events where maintenance_item_id=?";
        
        PreparedStatement deleteEventsForMaintenanceItemStatement = DbConfig.getDbConnection().prepareStatement(deleteEventsForMaintenanceItemSql);
        deleteEventsForMaintenanceItemStatement.setInt(1, maintenanceItemId);
        
        deleteEventsForMaintenanceItemStatement.executeUpdate();
    }

}
