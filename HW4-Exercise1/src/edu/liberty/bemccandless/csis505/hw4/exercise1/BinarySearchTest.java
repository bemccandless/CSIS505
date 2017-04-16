package edu.liberty.bemccandless.csis505.hw4.exercise1;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Altering the binarySearch method to be recursive
 * 
 * @author bemccandless
 */
public class BinarySearchTest {

    private static int[] data;
    
    public static int binarySearch(int[] data, int key) {
        int low = 0;
        int high = data.length - 1;
        int middle = (low + high + 1) / 2;
        int location = -1;
        
        do {
            System.out.print(remainingElements(data, low, high));
            
            for (int i = 0; i < middle; i++) {
                System.out.print("   ");
            }
            System.out.println(" * ");
            
            if (key == data[middle]) {
                location = middle;
            } else if (key < data[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            
            middle = (low + high + 1) / 2;
        } while ((low <= high) && (location == -1));
        
        return location;
    }
    
    private static String remainingElements(int[] data, int low, int high) {
        StringBuilder temporary = new StringBuilder();
        
        for (int i = 0; i < low; i++) {
            temporary.append("   ");
        }
        for (int i = low; i <= high; i++) {
            temporary.append(data[i] + " ");
        }
        
        return String.format("%s%n", temporary);
    }
    
    public static int recursiveSearchMcCandless(int key, int startIndex, int endIndex) {
        int middle = (startIndex + endIndex + 1) / 2;
        System.out.print(remainingElements(data, startIndex, endIndex));

        for (int i = 0; i < middle; i++) {
            System.out.print("   ");
        }
        System.out.println(" * ");
        
        if (key != data[middle] && (middle == startIndex || middle == endIndex)) {
            return -1;
        } else if (key == data[middle]) {
            return middle;
        } else if (key < data[middle]) {
            return recursiveSearchMcCandless(key, startIndex, middle - 1);
        }

        return recursiveSearchMcCandless(key, middle + 1, endIndex);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecureRandom generator = new SecureRandom();
        
        data = new int[15];
        
        for (int i = 0; i < data.length; i++) {
            data[i] = 10 + generator.nextInt(90);
        }
        
        Arrays.sort(data);
        System.out.printf("%s%n%n", Arrays.toString(data));
        
        System.out.print("Please enter an integer value (-1 to quit): ");
        int searchInt = input.nextInt();
        
        while (searchInt != -1) {
            int location = recursiveSearchMcCandless(searchInt, 0, data.length - 1);
            
            if (location == -1) {
                System.out.printf("%d was not found%n%n", searchInt);
            } else {
                System.out.printf("%d was found in position %d%n%n", searchInt, location);
            }
            
            System.out.print("Please enter an integer value (-1 to quit): ");
            searchInt = input.nextInt();
        }
    }
}
