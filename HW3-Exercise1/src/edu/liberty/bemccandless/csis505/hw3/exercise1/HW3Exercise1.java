package edu.liberty.bemccandless.csis505.hw3.exercise1;

import javax.swing.JFrame;

/**
 *
 * @author bemccandless
 */
public class HW3Exercise1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColorSelectorFrame colorSelectorFrame = new ColorSelectorFrame();
        colorSelectorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colorSelectorFrame.setSize(600, 400);
        colorSelectorFrame.setVisible(true);
    }

}
