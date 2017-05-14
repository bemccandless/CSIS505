package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

/**
 * Holds the information required to calculate the next service date and mileage
 * for the specific maintenance type.
 * 
 * @author bemccandless
 */
public class OilChange extends MaintenanceType {
    
    private static final String TYPE = "Oil Change";
    private static final int MONTHS_BETWEEN_SERVICE = 3;
    private static final int MILEAGE_BETWEEEN_SERVICE = 3000;

    public OilChange() {
        super(TYPE, MONTHS_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }

}
