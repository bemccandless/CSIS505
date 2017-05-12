package edu.liberty.bemccandless.csis505.finalproject.tuneup.event;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceService;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.VehicleService;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author bemccandless
 */
public class EventController {
    
    private final EventService eventService;
    private final VehicleService vehicleService;
    private final MaintenanceService maintenanceService;

    public EventController(EventService eventService, VehicleService vehicleService, MaintenanceService maintenanceService) {
        this.eventService = eventService;
        this.vehicleService = vehicleService;
        this.maintenanceService = maintenanceService;
    }

    public ListModel getAllEvents() throws SQLException {
        DefaultListModel<Event> events = new DefaultListModel();
        ResultSet eventResults = eventService.getAllEvents();
        
        while (eventResults.next()) {
            Event event = new Event();
            event.setId(eventResults.getInt("id"));
            event.setVehicle(vehicleService.getVehicleById(eventResults.getInt("vehicle_id")));
            event.setMaintenanceItem(maintenanceService.getMaintenanceItemById(eventResults.getInt("maintenance_item_id")));
            event.setEstimatedMaintenanceDate(eventResults.getDate("estimated_maintenance_date"));
            event.setRecommendedMileage(eventResults.getInt("recommended_mileage"));
            
            events.addElement(event);
        }
        
        return events;
    }
}
