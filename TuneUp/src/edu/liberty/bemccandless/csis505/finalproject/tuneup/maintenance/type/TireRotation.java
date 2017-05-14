package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

/**
 * Holds the information required to calculate the next service date and mileage
 * for the specific maintenance type.
 * 
 * @author bemccandless
 */
public class TireRotation extends MaintenanceType {
    
    private static final String TYPE = "Tire Rotation";
    private static final int MONTHS_BETWEEN_SERVICE = 6;
    private static final int MILEAGE_BETWEEEN_SERVICE = 6000;

    public TireRotation() {
        super(TYPE, MONTHS_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }
}
