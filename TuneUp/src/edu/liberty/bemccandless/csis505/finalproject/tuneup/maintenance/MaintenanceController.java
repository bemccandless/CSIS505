package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author bemccandless
 */
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }
    
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
            for (int i = 0; i < columnNames.length; i++) {
                rowValues[i] = itemResults.getObject(i + 1);
            }
            model.addRow(rowValues);
        }
        
        return model;
    }
    
    public void addMaintenanceItem(Vehicle vehicle, MaintenanceType maintenanceType, int serviceMileage, Date serviceDate, double price) throws SQLException {
        MaintenanceItem maintenanceItem = new MaintenanceItem(
                maintenanceType, serviceMileage, serviceDate, price);
        
        maintenanceService.addMaintenanceItem(vehicle, maintenanceItem);
    }
    
}
