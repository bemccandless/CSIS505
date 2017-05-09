package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

/**
 *
 * @author bemccandless
 */
public class Vehicle {
    
    private int id;
    private String driver;
    private String make;
    private String model;
    private int year;
    private int mileage;

    public Vehicle() {
    }

    public Vehicle(int id, String driver, String make, String model, int year, int mileage) {
        this.id = id;
        this.driver = driver;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s (%s)", year, make, model, driver);
    }
    
}
