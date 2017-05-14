package edu.liberty.bemccandless.csis505.finalproject.tuneup.event;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.config.DbConfig;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.MaintenanceType;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Handles database interactions for Events.
 * 
 * @author bemccandless
 */
public class EventService {
    
    /**
     * Calculate the next service date for maintenance based upon the last service date.
     * 
     * @param lastServiceDate
     * @param maintenanceType
     * @return 
     */
    public Date calculateEstimatedMaintenanceDate(Date lastServiceDate, MaintenanceType maintenanceType) {
        return maintenanceType.calculateNextServiceDate(lastServiceDate);
    }
    
    /**
     * Calculate the estimated mileage for maintenance based upon the current mileage of the vehicle.
     * 
     * @param currentMileage
     * @param maintenanceType
     * @return 
     */
    public int calculateEstimatedMaintenanceMileage(int currentMileage, MaintenanceType maintenanceType) {
        return maintenanceType.calculateNextServiceMileage(currentMileage);
    }
    
    /**
     * Get all events ordered by estimated maintenance date ascending.
     * 
     * @return
     * @throws SQLException 
     */
    public ResultSet getAllEvents() throws SQLException {
        String selectAllEventsSql = 
                "select * from tuneup.events order by estimated_maintenance_date";
        
        PreparedStatement selectAllEventsStatement = DbConfig.getDbConnection().prepareStatement(selectAllEventsSql);
        
        return selectAllEventsStatement.executeQuery();
    }
    
    /**
     * Add an event
     * 
     * @param event
     * @throws SQLException 
     */
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
    
    /**
     * Delete event for maintenance id.
     * 
     * @param maintenanceItemId
     * @throws SQLException 
     */
    public void deleteEventsForMaintenanceItem(int maintenanceItemId) throws SQLException {
        String deleteEventsForMaintenanceItemSql = "delete from events where maintenance_item_id=?";
        
        PreparedStatement deleteEventsForMaintenanceItemStatement = DbConfig.getDbConnection().prepareStatement(deleteEventsForMaintenanceItemSql);
        deleteEventsForMaintenanceItemStatement.setInt(1, maintenanceItemId);
        
        deleteEventsForMaintenanceItemStatement.executeUpdate();
    }
    
    /**
     * Delete events for vehicle.
     * 
     * @param vehicle
     * @throws SQLException 
     */
    public void deleteEventsForVehicle(Vehicle vehicle) throws SQLException {
        String deleteEventsForVehicleSql = "delete from events where vehicle_id=?";
        
        PreparedStatement deleteEventsForVehicleStatement = DbConfig.getDbConnection().prepareStatement(deleteEventsForVehicleSql);
        deleteEventsForVehicleStatement.setInt(1, vehicle.getId());
        
        deleteEventsForVehicleStatement.executeUpdate();
    }
    
    /**
     * Delete events by service type.
     * 
     * @param vehicle
     * @param serviceType
     * @throws SQLException 
     */
    public void deleteEventsByServiceType(Vehicle vehicle, String serviceType) throws SQLException {
        String deleteEventsByServiceTypeSql = 
                "delete from events where events.id in (select events.id from events"
                + " join maintenance_items on maintenance_items.id = events.maintenance_item_id"
                + " where maintenance_items.\"TYPE\"=?"
                + "     and events.vehicle_id=?)";
        
        PreparedStatement deleteEventsByServiceTypeStatement = DbConfig.getDbConnection().prepareStatement(deleteEventsByServiceTypeSql);
        deleteEventsByServiceTypeStatement.setString(1, serviceType);
        deleteEventsByServiceTypeStatement.setInt(2, vehicle.getId());
        
        deleteEventsByServiceTypeStatement.executeUpdate();
    }

}
