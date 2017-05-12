package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.MaintenanceType;
import java.time.Period;

/**
 *
 * @author bemccandless
 */
public class TireRotation extends MaintenanceType {
    
    private static final String TYPE = "Tire Rotation";
    private static final Period TIME_BETWEEN_SERVICE = Period.ofMonths(6);
    private static final int MILEAGE_BETWEEEN_SERVICE = 6000;

    public TireRotation() {
        super(TYPE, TIME_BETWEEN_SERVICE, MILEAGE_BETWEEEN_SERVICE);
    }
}
