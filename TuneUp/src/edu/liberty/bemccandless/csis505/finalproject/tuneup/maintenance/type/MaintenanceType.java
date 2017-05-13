package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

import java.sql.Date;
import java.util.Calendar;

/**
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

    public Date calculateNextServiceDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, monthsBetweenService);
        
        return new Date(cal.getTimeInMillis());
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
