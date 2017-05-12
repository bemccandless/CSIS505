package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import java.sql.Date;
import java.time.Period;

/**
 *
 * @author bemccandless
 */
public abstract class MaintenanceType {
    
    private String type;
    private Period timeBetweenService;
    private int mileageBetweenService;

    public MaintenanceType(String type, Period timeBetweenService, int mileageBetweenService) {
        this.type = type;
        this.timeBetweenService = timeBetweenService;
        this.mileageBetweenService = mileageBetweenService;
    }

    public Date calculateNextServiceDate(Date date) {
        // TODO: add calculation logic
        return new Date(0);
    }
    
    public int calculateNextServiceMileage(int mileage) {
        return mileage + this.mileageBetweenService;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Period getTimeBetweenService() {
        return timeBetweenService;
    }

    public void setTimeBetweenService(Period timeBetweenService) {
        this.timeBetweenService = timeBetweenService;
    }

    public int getMileageBetweenService() {
        return mileageBetweenService;
    }

    public void setMileageBetweenService(int mileageBetweenService) {
        this.mileageBetweenService = mileageBetweenService;
    }
    
}
