package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

/**
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
