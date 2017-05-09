package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.config.DbConfig;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bemccandless
 */
public class VehicleService {

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
