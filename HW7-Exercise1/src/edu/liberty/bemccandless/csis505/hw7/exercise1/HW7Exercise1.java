package edu.liberty.bemccandless.csis505.hw7.exercise1;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Searches a list of random integers for a prompted input
 * 
 * @author bemccandless
 */
public class HW7Exercise1 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        // List of Integers
        List<Integer> intList = new List();
        for (int i = 0; i < 20; i++) {
            int randomNumber = new SecureRandom().nextInt(50);
            intList.insertAtFront(randomNumber);
        }
        intList.print();
        
        System.out.print("Please enter an integer value (-1 to quit): ");
        Integer searchInt = input.nextInt();
        
        while (searchInt != -1) {
            Integer intFound = intList.findItemRecursivelyMcCandless(searchInt);
            
            if (intFound == null) {
                System.out.printf("%d was not found%n%n", searchInt);
            } else {
                System.out.printf("%d was found%n%n", searchInt);
            }
            
            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = input.nextInt();
        }
        
    }

}
