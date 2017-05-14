package edu.liberty.bemccandless.csis505.finalproject.tuneup.vehicle;

/**
 * Holds all the information for a vehicle.
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

    public int getId() {
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

    /**
     * Formats the string for how it is displayed in the vehicles list.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return String.format("%d %s %s (%s)", year, make, model, driver);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
