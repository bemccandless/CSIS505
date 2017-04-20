package edu.liberty.bemccandless.csis505.hw5.exercise1;

/**
 * This application provides a generic method for comparing two given arguments
 * and evaluates whether or not they are equal to each other using the 
 * <code>equals()</code> method.
 * 
 * @author bemccandless
 */
public class HW5Exercise1 {

    public static void main(String[] args) {
        // Test 1: Compare Integers - True
        Integer int1 = 1;
        System.out.printf("Is [%s] equal to [%s]? %b%n%n", 
                int1, int1, compareToMcCandless(int1, int1));
        
        // Test 2: Compare Integers - False
        Integer int2 = 2;
        System.out.printf("Is [%s] equal to [%s]? %b%n%n", 
                int1, int2, compareToMcCandless(int1, int2));
        
        // Test 3: Compare Strings - True
        String str1 = "string 1";
        System.out.printf("Is [%s] equal to [%s]? %b%n%n", 
                str1, str1, compareToMcCandless(str1, str1));
        
        // Test 4: Compare Strings - False
        String str2 = "string 2";
        System.out.printf("Is [%s] equal to [%s]? %b%n%n", 
                str1, str2, compareToMcCandless(str1, str2));
        
        // Test 5: Compare Objects - True
        Object obj1 = new Object();
        System.out.printf("Is [%s] equal to [%s]? %b%n%n", 
                obj1, obj1, compareToMcCandless(obj1, obj1));
        
        // Test 6: Compare Objects - False
        Object obj2 = new Object();
        System.out.printf("Is [%s] equal to [%s]? %b%n%n", 
                obj1, obj2, compareToMcCandless(obj1, obj2));
        
    }
    
    /**
     * Compare two arguments to evaluate their equality
     * 
     * @param <T>
     * @param arg1
     * @param arg2
     * @return boolean result of comparing two arguments
     */
    private static <T> boolean compareToMcCandless(T arg1, T arg2) {
        return arg1.equals(arg2);
    }
    
}
