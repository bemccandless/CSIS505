package edu.liberty.bemccandless.csis505.finalproject.tuneup.event;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceItem;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.Date;

/**
 *
 * @author bemccandless
 */
public class Event {
    
    private Vehicle vehicle;
    private MaintenanceItem maintenanceItem;
    private Date estimatedMaintenanceDate;
    private int recommendedMileage;

    public Event() {
    }

    public Event(Vehicle vehicle, MaintenanceItem maintenanceItem, Date estimatedMaintenanceDate, int recommendedMileage) {
        this.vehicle = vehicle;
        this.maintenanceItem = maintenanceItem;
        this.estimatedMaintenanceDate = estimatedMaintenanceDate;
        this.recommendedMileage = recommendedMileage;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public MaintenanceItem getMaintenanceItem() {
        return maintenanceItem;
    }

    public void setMaintenanceItem(MaintenanceItem maintenanceItem) {
        this.maintenanceItem = maintenanceItem;
    }

    public Date getEstimatedMaintenance() {
        return estimatedMaintenanceDate;
    }

    public void setEstimatedMaintenance(Date estimatedMaintenanceDate) {
        this.estimatedMaintenanceDate = estimatedMaintenanceDate;
    }

    public int getRecommendedMileage() {
        return recommendedMileage;
    }

    public void setRecommendedMileage(int recommendedMileage) {
        this.recommendedMileage = recommendedMileage;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s%nRecommended Mileage: %s%nEstimated Date: %s",
                vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), 
                maintenanceItem.getMaintenanceType().getType(), this.getRecommendedMileage(), 
                this.getEstimatedMaintenance());
    }
    
}
