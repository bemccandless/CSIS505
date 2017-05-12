package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceType;
import java.time.Period;

/**
 *
 * @author bemccandless
 */
public class AirFilterReplacement extends MaintenanceType {

    private static final String TYPE = "Air Filter Replacement";
    private static final Period TIME_BETWEEN_SERVICE = Period.ofYears(1);
    private static final int MILEAGE_BETWEEEN_SERVICE = 10000;

    public AirFilterReplacement() {
        super(TYPE, TIME_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }
}
