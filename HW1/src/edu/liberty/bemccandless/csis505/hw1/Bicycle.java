package edu.liberty.bemccandless.csis505.hw1;

/**
 *
 * @author bemccandless
 */
public class Bicycle implements CarbonFootprint {
    private double milesTraveledPerMonth;

    public Bicycle(double milesTraveledPerMonth) throws InvalidFootprintException {
        if (milesTraveledPerMonth < 0) {
            throw new InvalidFootprintException();
        }
        
        this.milesTraveledPerMonth = milesTraveledPerMonth;
    }

    @Override
    public double getCarbonFootprint() {
        return milesTraveledPerMonth * 0.9;
    }

    public double getMilesTraveledPerMonth() {
        return milesTraveledPerMonth;
    }

    public void setMilesTraveledPerMonth(double milesTraveledPerMonth) {
        this.milesTraveledPerMonth = milesTraveledPerMonth;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %.2f", 
                "Bicycle", "-----------------------------------",
                "Miles Traveled Per Month", getMilesTraveledPerMonth());
    }

}
