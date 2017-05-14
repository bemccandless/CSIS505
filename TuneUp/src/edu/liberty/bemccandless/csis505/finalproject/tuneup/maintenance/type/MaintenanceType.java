package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

import java.sql.Date;
import java.util.Calendar;

/**
 * An abstract class for different maintenance types to use in order to have a
 * central place to calculate the estimated mileage and service date.
 * 
 * @author bemccandless
 */
public abstract class MaintenanceType {
    
    private String type;
    private int monthsBetweenService;
    private int mileageBetweenService;

    public MaintenanceType(String type, int monthsBetweenService, int mileageBetweenService) {
        this.type = type;
        this.monthsBetweenService = monthsBetweenService;
        this.mileageBetweenService = mileageBetweenService;
    }

    /**
     * Calculates the next service date.
     * 
     * @param date
     * @return 
     */
    public Date calculateNextServiceDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.MONTH, monthsBetweenService);
        
        return new Date(cal.getTimeInMillis());
    }
    
    /**
     * Calculates the next service mileage.
     * 
     * @param mileage
     * @return 
     */
    public int calculateNextServiceMileage(int mileage) {
        return mileage + this.mileageBetweenService;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMonthsBetweenService() {
        return monthsBetweenService;
    }

    public void setMonthsBetweenService(int monthsBetweenService) {
        this.monthsBetweenService = monthsBetweenService;
    }


    public int getMileageBetweenService() {
        return mileageBetweenService;
    }

    public void setMileageBetweenService(int mileageBetweenService) {
        this.mileageBetweenService = mileageBetweenService;
    }
    
}
