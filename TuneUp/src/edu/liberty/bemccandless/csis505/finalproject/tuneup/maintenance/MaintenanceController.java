package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.event.EventService;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.MaintenanceType;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Maintains a level of control between the data layer and the view layer for Maintenance Items.
 * 
 * @author bemccandless
 */
public class MaintenanceController {

    private final MaintenanceService maintenanceService;
    private final EventService eventService;

    public MaintenanceController(MaintenanceService maintenanceService, EventService eventService) {
        this.maintenanceService = maintenanceService;
        this.eventService = eventService;
    }
    
    /**
     * Get all maintenance types.
     * 
     * @return 
     */
    public ComboBoxModel<MaintenanceType> getAllMaintenanceTypes() {
        return new DefaultComboBoxModel(maintenanceService.getAllMaintenanceTypes().toArray());
    }
    
    /**
     * Get all maintenance items by vehicle.
     * 
     * @param vehicle
     * @return
     * @throws SQLException 
     */
    public TableModel getMaintenanceItemsByVehicle(Vehicle vehicle) throws SQLException {
        ResultSet itemResults = maintenanceService.getMaintenanceItemsByVehicle(vehicle);
        ResultSetMetaData itemMetadata = itemResults.getMetaData();
        
        String[] columnNames = new String[itemMetadata.getColumnCount()];
        for (int i = 0; i < itemMetadata.getColumnCount(); i++) {
            columnNames[i] = itemMetadata.getColumnName(i + 1);
        }
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        while (itemResults.next()) {
            Object[] rowValues = new Object[columnNames.length];
            int i = 0;
            for (String columnName : columnNames) {
                if ("PRICE".equals(columnName)) {
                    rowValues[i] = NumberFormat.getCurrencyInstance().format(itemResults.getObject(i + 1));
                } else {
                    rowValues[i] = itemResults.getObject(i + 1);
                }
                
                i++;
            }
            model.addRow(rowValues);
        }
        
        return model;
    }
    
    /**
     * Add a maintenance item.
     * 
     * @param vehicle
     * @param maintenanceItem
     * @throws SQLException 
     */
    public void addMaintenanceItem(Vehicle vehicle, MaintenanceItem maintenanceItem) throws SQLException {
        eventService.deleteEventsByServiceType(vehicle, maintenanceItem.getMaintenanceType().getType());
        maintenanceService.addMaintenanceItem(vehicle, maintenanceItem);
    }
    
    
    /**
     * Delete a maintenance item.
     * 
     * @param maintenanceItemId
     * @throws SQLException 
     */
    public void deleteMaintenanceItem(int maintenanceItemId) throws SQLException {
        eventService.deleteEventsForMaintenanceItem(maintenanceItemId);
        maintenanceService.deleteMaintenanceItem(maintenanceItemId);
    }
    
}
