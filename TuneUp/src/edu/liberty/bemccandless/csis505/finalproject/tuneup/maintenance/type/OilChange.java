package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceType;
import java.time.Period;

/**
 *
 * @author bemccandless
 */
public class OilChange extends MaintenanceType {
    
    private static final String TYPE = "Oil Change";
    private static final Period TIME_BETWEEN_SERVICE = Period.ofMonths(3);
    private static final int MILEAGE_BETWEEEN_SERVICE = 3000;

    public OilChange() {
        super(TYPE, TIME_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }

}
