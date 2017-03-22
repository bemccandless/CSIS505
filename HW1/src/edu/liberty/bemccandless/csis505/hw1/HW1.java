package edu.liberty.bemccandless.csis505.hw1;

/**
 *
 * @author bemccandless
 */
public class HW1 {

    /**
     * Prints out the variables and values for each object created that extends the CarbonFootprint interface
     * 
     * @param args
     */
    public static void main(String[] args) {
        final String ERROR_MESSAGE = "Invalid footprint detected";
        
        // InvalidFootprintException should be thrown if negative values are passed 
        // into the constructor
        try {
            Bicycle bicycleError = new Bicycle(-100);
        } catch (InvalidFootprintException ex) {
            System.err.printf("%s%n", ERROR_MESSAGE);
        }
        try {
            Building buildingError = new Building(100, -200);
        } catch (InvalidFootprintException ex) {
            System.err.printf("%s%n", ERROR_MESSAGE);
        }
        try {
            Car carError = new Car(-5000, 30);
        } catch (InvalidFootprintException ex) {
            System.err.printf("%s%n", ERROR_MESSAGE);
        }
        
        // Successful data
        try {
            Building building = new Building(100, 200);
            Car car = new Car(5000, 30);
            Bicycle bicycle = new Bicycle(100);
            
            CarbonFootprint[] carbonFootprints = {building, car, bicycle};
            
            printCarbonFootprint(carbonFootprints);
        } catch (InvalidFootprintException ex) {
            System.err.printf("%s%n", "Invalid footprint detected");
        }
    }
    
    /**
     * Print the variables for each object along with it's CarbonFootprint
     * 
     * @param carbonFootprints 
     */
    private static void printCarbonFootprint(CarbonFootprint[] carbonFootprints) {
        for (CarbonFootprint carbonFootprint : carbonFootprints) {
            System.out.printf("%s%n%s: %.2f%n%n", carbonFootprint.toString(),
                              "Carbon Footprint", carbonFootprint.getCarbonFootprint());
        }
    }
    
}
