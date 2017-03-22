package edu.liberty.bemccandless.csis505.hw1;

/**
 *
 * @author bemccandless
 */
public class Building implements CarbonFootprint {
    private double monthlyElectricBill;
    private double monthlyGasBill;

    /**
     * 
     * @param monthlyElectricBill
     * @param monthlyGasBill
     * @throws InvalidFootprintException 
     */
    public Building(double monthlyElectricBill, double monthlyGasBill) throws InvalidFootprintException {
        if (monthlyElectricBill < 0 || monthlyGasBill < 0) {
            throw new InvalidFootprintException();
        }
        
        this.monthlyElectricBill = monthlyElectricBill;
        this.monthlyGasBill = monthlyGasBill;
    }

    /**
     * 
     * @return the calculated carbon footprint
     */
    @Override
    public double getCarbonFootprint() {
        return ((monthlyGasBill / 10.68) * 119.58 * 12) + ((monthlyElectricBill / 0.1188) * 1232 * 12);
    }

    public double getMonthlyElectricBill() {
        return monthlyElectricBill;
    }

    public void setMonthlyElectricBill(double monthlyElectricBill) {
        this.monthlyElectricBill = monthlyElectricBill;
    }

    public double getMonthlyGasBill() {
        return monthlyGasBill;
    }

    public void setMonthlyGasBill(double monthlyGasBill) {
        this.monthlyGasBill = monthlyGasBill;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s%n%s: %.2f%n%s: %.2f", 
                "Building", "-----------------------------------",
                "Monthly Electric Bill", getMonthlyElectricBill(),
                "Monthly Gas Bill", getMonthlyGasBill());
    }

}
