package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.AirFilterReplacement;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.BrakeReplacement;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.Inspection;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.NewTires;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.OilChange;
import edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance.type.TireRotation;

/**
 *
 * @author bemccandless
 */
public final class MaintenanceTypeFactory {

    public static MaintenanceType getMaintenanceType(String type) {
        if ("Oil Change".equals(type)) {
            return new OilChange();
        } else if ("Tire Rotation".equals(type)) {
            return new TireRotation();
        } else if ("New Tires".equals(type)) {
            return new NewTires();
        } else if ("Inspection".equals(type)) {
            return new Inspection();
        } else if ("Brake Replacement".equals(type)) {
            return new BrakeReplacement();
        } else if ("Air Filter Replacement".equals(type)) {
            return new AirFilterReplacement();
        } 
        
        return null;
    }
}
