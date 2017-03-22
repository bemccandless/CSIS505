package edu.liberty.bemccandless.csis505.hw1;

/**
 *
 * @author bemccandless
 */
public class Car implements CarbonFootprint {
    private double milesDrivenPerYear;
    private double milesPerGallon;

    /**
     * 
     * @param milesDrivenPerYear
     * @param milesPerGallon
     * @throws InvalidFootprintException 
     */
    public Car(double milesDrivenPerYear, double milesPerGallon) throws InvalidFootprintException {
        if (milesDrivenPerYear < 0 || milesPerGallon < 0) {
            throw new InvalidFootprintException();
        }
        
        this.milesDrivenPerYear = milesDrivenPerYear;
        this.milesPerGallon = milesPerGallon;
    }

    /**
     * 
     * @return the calculated carbon footprint
     */
    @Override
    public double getCarbonFootprint() {
        return milesDrivenPerYear / milesPerGallon * 0.9;
    }

    public double getMilesDrivenPerYear() {
        return milesDrivenPerYear;
    }

    public void setMilesDrivenPerYear(double milesDrivenPerYear) {
        this.milesDrivenPerYear = milesDrivenPerYear;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    public void setMilesPerGallon(double milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %.2f%n%s: %.2f", 
                "Car", "-----------------------------------",
                "Miles Driven Per Year", getMilesDrivenPerYear(),
                "Miles Per Gallon", getMilesPerGallon());
    }
    
}
