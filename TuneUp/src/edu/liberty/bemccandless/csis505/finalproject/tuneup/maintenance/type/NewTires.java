package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

/**
 *
 * @author bemccandless
 */
public class NewTires extends MaintenanceType{

    private static final String TYPE = "New Tires";
    private static final int MONTHS_BETWEEN_SERVICE = 36;
    private static final int MILEAGE_BETWEEEN_SERVICE = 60000;

    public NewTires() {
        super(TYPE, MONTHS_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }
}
