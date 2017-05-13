package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.MaintenanceType;
import java.sql.Date;

/**
 *
 * @author bemccandless
 */
public class MaintenanceItem {
    
    private int id;
    private MaintenanceType maintenanceType;
    private int serviceMileage;
    private Date serviceDate;
    private double price;

    public MaintenanceItem() {
    }

    public MaintenanceItem(int id, MaintenanceType maintenanceType, int serviceMileage, Date serviceDate, double price) {
        this.id = id;
        this.maintenanceType = maintenanceType;
        this.serviceMileage = serviceMileage;
        this.serviceDate = serviceDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MaintenanceType getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(MaintenanceType maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public int getServiceMileage() {
        return serviceMileage;
    }

    public void setServiceMileage(int serviceMileage) {
        this.serviceMileage = serviceMileage;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
