package edu.liberty.bemccandless.csis505.hw2;

import javax.swing.JFrame;

/**
 *
 * Presents a interface for the user to convert a date formatted mm/dd/yyyy
 * into a long date format
 * 
 * @author bemccandless
 */
public class HW2Exercise2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DateFormatterFrame dateFormatterFrame = new DateFormatterFrame();
        dateFormatterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dateFormatterFrame.setSize(475, 150);
        dateFormatterFrame.setVisible(true);
    }
    
}
