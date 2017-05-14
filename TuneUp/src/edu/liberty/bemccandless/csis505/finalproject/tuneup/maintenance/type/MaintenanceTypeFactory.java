package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

/**
 * Provides a matching class for a specified maintenance type.
 * 
 * @author bemccandless
 */
public final class MaintenanceTypeFactory {

    public static MaintenanceType getMaintenanceType(String type) {
        if ("Oil Change".equals(type)) {
            return new OilChange();
        } else if ("Tire Rotation".equals(type)) {
            return new TireRotation();
        } else if ("New Tires".equals(type)) {
            return new NewTires();
        } else if ("Inspection".equals(type)) {
            return new Inspection();
        } else if ("Brake Replacement".equals(type)) {
            return new BrakeReplacement();
        } else if ("Air Filter Replacement".equals(type)) {
            return new AirFilterReplacement();
        } 
        
        return null;
    }
}
