package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.OilChange;

/**
 *
 * @author bemccandless
 */
public final class MaintenanceTypeFactory {

    public static MaintenanceType getMaintenanceType(String type) {
        if ("Oil Change".equals(type)) {
            return new OilChange();
        }
        
        return null;
    }
}
