package edu.liberty.bemccandless.csis505.hw3.exercise1.colors;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bemccandless
 */
public final class ColorMap {
    
    private static final Map<String, Color> COLORS = new HashMap<>();

    static {
        COLORS.put("Black", Color.BLACK);
        COLORS.put("Blue", Color.BLUE);
        COLORS.put("Cyan", Color.CYAN);
        COLORS.put("Dark Gray", Color.DARK_GRAY);
        COLORS.put("Gray", Color.GRAY);
        COLORS.put("Green", Color.GREEN);
        COLORS.put("Light Gray", Color.LIGHT_GRAY);
        COLORS.put("Magenta", Color.MAGENTA);
        COLORS.put("Orange", Color.ORANGE);
        COLORS.put("Pink", Color.PINK);
        COLORS.put("Red", Color.RED);
        COLORS.put("White", Color.WHITE);
        COLORS.put("Yellow", Color.YELLOW);
    }

    public static Map<String, Color> getColors() {
        return COLORS;
    }
    
}
