package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

/**
 * Holds the information required to calculate the next service date and mileage
 * for the specific maintenance type.
 * 
 * @author bemccandless
 */
public class BrakeReplacement extends MaintenanceType {

    private static final String TYPE = "Brake Replacement";
    private static final int MONTHS_BETWEEN_SERVICE = 24;
    private static final int MILEAGE_BETWEEEN_SERVICE = 40000;

    public BrakeReplacement() {
        super(TYPE, MONTHS_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }
}
