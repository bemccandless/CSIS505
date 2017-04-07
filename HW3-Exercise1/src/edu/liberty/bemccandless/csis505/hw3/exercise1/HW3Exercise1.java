package edu.liberty.bemccandless.csis505.hw3.exercise1;

import javax.swing.JFrame;

/**
 * When selecting a color from a provided list the 
 * background of the window will change to the selected color.
 * 
 * @author bemccandless
 */
public class HW3Exercise1 {
    
    /**
     * Creates the frame, size it and make it visible
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColorSelectorFrame colorSelectorFrame = new ColorSelectorFrame();
        colorSelectorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorSelectorFrame.setSize(600, 400);
        colorSelectorFrame.setVisible(true);
    }

}
