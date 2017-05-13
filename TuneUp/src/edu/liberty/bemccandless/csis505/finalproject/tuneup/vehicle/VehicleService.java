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
    
    public Vehicle getVehicleById(int id) throws SQLException {
        String selectVehicleByIdSql = "select * from tuneup.vehicles where id=?";
        
        PreparedStatement selectVehicleByIdStatement = DbConfig.getDbConnection().prepareStatement(selectVehicleByIdSql);
        selectVehicleByIdStatement.setInt(1, id);
        
        ResultSet vehicleResults = selectVehicleByIdStatement.executeQuery();

        Vehicle vehicle = null;
        while (vehicleResults.next()) {
            vehicle = new Vehicle(
                    vehicleResults.getInt("id"),
                    vehicleResults.getString("driver"),
                    vehicleResults.getString("make"),
                    vehicleResults.getString("model"),
                    vehicleResults.getInt("year"),
                    vehicleResults.getInt("mileage"));
        }
        
        return vehicle;
    }
    
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
    
    public void editVehicle(Vehicle vehicle) throws SQLException {
        String updateVehicleSql = "update tuneup.vehicles set driver=?, make=?, model=?, \"year\"=?, mileage=? where id=?";
        
        PreparedStatement updateVehicleStatement = DbConfig.getDbConnection().prepareStatement(updateVehicleSql, Statement.RETURN_GENERATED_KEYS);
        updateVehicleStatement.setString(1, vehicle.getDriver());
        updateVehicleStatement.setString(2, vehicle.getMake());
        updateVehicleStatement.setString(3, vehicle.getModel());
        updateVehicleStatement.setInt(4, vehicle.getYear());
        updateVehicleStatement.setInt(5, vehicle.getMileage());
        updateVehicleStatement.setInt(6, vehicle.getId());
        
        updateVehicleStatement.executeUpdate();
    }
    
    public void deleteVehicle(Vehicle vehicle) throws SQLException {
        String deleteVehicleSql = "delete from vehicles where id=?";
        
        PreparedStatement deleteVehicleStatement = DbConfig.getDbConnection().prepareStatement(deleteVehicleSql);
        deleteVehicleStatement.setInt(1, vehicle.getId());
        
        deleteVehicleStatement.executeUpdate();
    }
}
