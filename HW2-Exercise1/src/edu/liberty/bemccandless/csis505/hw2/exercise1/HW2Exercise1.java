package edu.liberty.bemccandless.csis505.hw2.exercise1;

import javax.swing.JFrame;

/**
 * Presents a interface for the user to calculate the number of 
 * spam words found in a provided text
 * 
 * @author bemccandless
 */
public class HW2Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SpamScoreCalculatorFrame calculatorFrame = new SpamScoreCalculatorFrame();
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setSize(600, 400);
        calculatorFrame.setVisible(true);
    }
    
}
