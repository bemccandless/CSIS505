package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.config.DbConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author bemccandless
 */
public class VehicleService {

    public ListModel<Vehicle> getAllVehicles() throws SQLException {
        String selectVehiclesSql = "select * from tuneup.vehicles order by \"year\", make, model, driver";
        
        PreparedStatement selectVehiclesStatement = DbConfig.getDbConnection().prepareStatement(selectVehiclesSql);
        ResultSet vehicleResults = selectVehiclesStatement.executeQuery();

        DefaultListModel<Vehicle> vehicles = new DefaultListModel();
        while (vehicleResults.next()) {
            vehicles.addElement(new Vehicle(
                    vehicleResults.getInt("id"),
                    vehicleResults.getString("driver"),
                    vehicleResults.getString("make"),
                    vehicleResults.getString("model"),
                    vehicleResults.getInt("year"),
                    vehicleResults.getInt("mileage")));
        }
        
        return vehicles;
    }
    
    public void addVehicle(Vehicle vehicle) throws SQLException {
        String insertVehicleSql = "insert into tuneup.vehicles (driver, make, model, \"year\", mileage) values (?, ?, ?, ?, ?)";
        
        PreparedStatement insertVehicleStatement = DbConfig.getDbConnection().prepareStatement(insertVehicleSql, Statement.RETURN_GENERATED_KEYS);
        insertVehicleStatement.setString(1, vehicle.getDriver());
        insertVehicleStatement.setString(2, vehicle.getMake());
        insertVehicleStatement.setString(3, vehicle.getModel());
        insertVehicleStatement.setInt(4, vehicle.getYear());
        insertVehicleStatement.setInt(5, vehicle.getMileage());
        
        insertVehicleStatement.executeUpdate();
        
        ResultSet generatedKey = insertVehicleStatement.getGeneratedKeys();
        if (generatedKey.next()) {
            vehicle.setId(generatedKey.getInt(1));
        }
        
    }
    
    public void editVehicle(Vehicle vehicle) {
        
    }
    
    public void deleteVehicle(Vehicle vehicle) {
        
    }
}
