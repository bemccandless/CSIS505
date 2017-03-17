package edu.liberty.bemccandless.csis505.hw1;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bemccandless
 */
public class HW1 {

    public static void main(String[] args) {
        try {
            Building building = new Building(100, 200);
            Car car = new Car(5000, 30);
            Bicycle bicycle = new Bicycle(100);
            
            List<CarbonFootprint> carbonFootprints = Arrays.asList(building, car, bicycle);
            
            printCarbonFootprint(carbonFootprints);
        } catch (InvalidFootprintException ex) {
            System.err.printf("%s%n", "Invalid footprint detected");
        }
    }
    
    private static void printCarbonFootprint(List<CarbonFootprint> carbonFootprints) {
        for (CarbonFootprint carbonFootprint : carbonFootprints) {
            System.out.printf("%s%n%s: %.2f%n%n", carbonFootprint.toString(),
                              "Carbon Footprint", carbonFootprint.getCarbonFootprint());
        }
    }
    
}
