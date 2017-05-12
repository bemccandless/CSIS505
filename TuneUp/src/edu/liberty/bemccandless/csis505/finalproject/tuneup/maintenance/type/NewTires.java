package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceType;
import java.time.Period;

/**
 *
 * @author bemccandless
 */
public class NewTires extends MaintenanceType{

    private static final String TYPE = "New Tires";
    private static final Period TIME_BETWEEN_SERVICE = Period.ofYears(3);
    private static final int MILEAGE_BETWEEEN_SERVICE = 60000;

    public NewTires() {
        super(TYPE, TIME_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }
}
