package edu.liberty.bemccandless.csis505.finalproject.tuneup.event;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceItem;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle.Vehicle;
import java.sql.Date;

/**
 * Holds information for an upcoming maintenance item.
 * 
 * @author bemccandless
 */
public class Event {
    
    private int id;
    private Vehicle vehicle;
    private MaintenanceItem maintenanceItem;
    private Date estimatedMaintenanceDate;
    private int recommendedMileage;

    public Event() {
    }

    public Event(int id, Vehicle vehicle, MaintenanceItem maintenanceItem, Date estimatedMaintenanceDate, int recommendedMileage) {
        this.id = id;
        this.vehicle = vehicle;
        this.maintenanceItem = maintenanceItem;
        this.estimatedMaintenanceDate = estimatedMaintenanceDate;
        this.recommendedMileage = recommendedMileage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getEstimatedMaintenanceDate() {
        return estimatedMaintenanceDate;
    }

    public void setEstimatedMaintenanceDate(Date estimatedMaintenanceDate) {
        this.estimatedMaintenanceDate = estimatedMaintenanceDate;
    }

    public int getRecommendedMileage() {
        return recommendedMileage;
    }

    public void setRecommendedMileage(int recommendedMileage) {
        this.recommendedMileage = recommendedMileage;
    }

    /**
     * Formats the display of an upcoming maintenance item in the list.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return String.format(
                    "<html>\n" +
                    "	<div style='padding: 5px 0px;'>\n" +
                    "		<div style='padding: 2px 0px'>\n" +
                    "			<b>%s -- %d %s %s (%s)</b>\n" +
                    "		</div>\n" +
                    "		<div>\n" +
                    "			Recommended Mileage:  %s\n" +
                    "		</div>\n" +
                    "		<div>\n" +
                    "			Estimated Service Date: %s\n" +
                    "		</div>\n" +
                    "	</div>\n" +
                    "</html>",
                maintenanceItem.getMaintenanceType().getType(), vehicle.getYear(), 
                vehicle.getMake(), vehicle.getModel(), vehicle.getDriver(), this.getRecommendedMileage(), 
                this.getEstimatedMaintenanceDate());
    }
    
}
