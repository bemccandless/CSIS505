package edu.liberty.bemccandless.csis505.finalproject.tuneup.maintenance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bemccandless
 */
public enum MaintenanceType {
    AIR_FILTER_REPLACEMENT("Air Filter Replacement"), BRAKE_REPLACEMENT("Brake Replacement"), 
    INSPECTION("Inspection"), NEW_TIRES("New Tires"), OIL_CHANGE("Oil Change"), TIRE_ROTATION("Tire Rotation");
    
    private final String item;
    
    MaintenanceType(String item) {
        this.item = item;
    }
    
    public String getItem() {
        return item;
    }
    
    public static MaintenanceType getType(String item) {
        for (MaintenanceType value : MaintenanceType.values()) {
            if(value.getItem().equals(item)) {
                return value;
            }
        }
        throw new IllegalStateException();
    }
    
    public static String[] getItems() {
        List<String> items = new ArrayList();
        for (MaintenanceType value : MaintenanceType.values()) {
            items.add(value.getItem());
        }
        
        return items.toArray(new String[items.size()]);
    }
}
