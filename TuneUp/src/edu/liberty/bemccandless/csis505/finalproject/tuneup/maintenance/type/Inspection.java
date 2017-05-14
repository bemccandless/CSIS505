package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

/**
 * Holds the information required to calculate the next service date and mileage
 * for the specific maintenance type.
 * 
 * @author bemccandless
 */
public class Inspection extends MaintenanceType {

    private static final String TYPE = "Inspection";
    private static final int MONTHS_BETWEEN_SERVICE = 12;
    private static final int MILEAGE_BETWEEEN_SERVICE = 20000;

    public Inspection() {
        super(TYPE, MONTHS_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }
}
