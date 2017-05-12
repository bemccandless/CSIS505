package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.config.DbConfig;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;

/**
 *
 * @author bemccandless
 */
public class MaintenanceService {
    
    public ResultSet getMaintenanceItemsByVehicle(Vehicle vehicle) throws SQLException {
        String selectItemsSql = 
                "select \"TYPE\", mileage, service_date, price from tuneup.maintenance_items "
                + " where vehicle_id=?"
                + " order by service_date desc";
        
        PreparedStatement selectItemsStatement = DbConfig.getDbConnection().prepareStatement(selectItemsSql);
        selectItemsStatement.setInt(1, vehicle.getId());
        
        return selectItemsStatement.executeQuery();
    }

    public void addMaintenanceItem(Vehicle vehicle, MaintenanceItem maintenanceItem) throws SQLException {
        String insertMaintenanceSql = "insert into tuneup.maintenance_items (vehicle_id, type, mileage, service_date, price) values (?, ?, ?, ?, ?)";
        
        PreparedStatement insertMaintenanceStatement = DbConfig.getDbConnection().prepareStatement(insertMaintenanceSql, Statement.RETURN_GENERATED_KEYS);
        insertMaintenanceStatement.setInt(1, vehicle.getId());
        insertMaintenanceStatement.setString(2, maintenanceItem.getMaintenanceType().getItem());
        insertMaintenanceStatement.setInt(3, maintenanceItem.getServiceMileage());
        insertMaintenanceStatement.setDate(4, maintenanceItem.getServiceDate());
        insertMaintenanceStatement.setString(5, NumberFormat.getCurrencyInstance().format(maintenanceItem.getPrice()));
        
        insertMaintenanceStatement.executeUpdate();
        
        ResultSet generatedKey = insertMaintenanceStatement.getGeneratedKeys();
        if (generatedKey.next()) {
            vehicle.setId(generatedKey.getInt(1));
        }
    }
}
