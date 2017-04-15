package edu.liberty.bemccandless.csis505.hw4.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Evaluating the effort and efficiency of how long Selection Sort, Insertion Sort
 * and Merge Sort takes to sort a given data array.
 * 
 * @author bemccandless
 */
public class HW4Exercise2 {

    private static final Evaluator evaluator = new Evaluator();
    private static final List<Long> selectionSortResults = new ArrayList();
    private static final List<Long> insertionSortResults = new ArrayList();
    private static final List<Long> mergeSortResults = new ArrayList();
    private static List<int[]> dataArrays;
    
    public static void main(String[] args) {
        int size;
        
        // Sort dataset of 100000 elements
        size = 100000;
        sortDataArrays(size);
        printResults(selectionSortResults, insertionSortResults, mergeSortResults, size);
        
        // Sort dataset of 1000 elements
        size = 1000;
        sortDataArrays(size);
        printResults(selectionSortResults, insertionSortResults, mergeSortResults, size);
    }
    
    /**
     * Takes the size of the array you would like to sort.  It creates three arrays, one sequentially,
     * one reversed and one random for each of the three sorting algorithms.  It then adds the results
     * of each of the findings to an <code>List<Long></code> for each algorithm.
     * 
     * @param size 
     */
    private static void sortDataArrays(int size) {
        dataArrays = createDataArrays(size);
        for (int[] dataArray : dataArrays) {
            selectionSortResults.add(sortArray(dataArray, (data) -> evaluator.selectionSortMcCandless(data)));
        }
        dataArrays = createDataArrays(size);
        for (int[] dataArray : dataArrays) {
            insertionSortResults.add(sortArray(dataArray, (data) -> evaluator.insertionSortMcCandless(data)));
        }
        dataArrays = createDataArrays(size);
        for (int[] dataArray : dataArrays) {
            mergeSortResults.add(sortArray(dataArray, (data) -> evaluator.mergeSortMcCandless(data)));
        }
    }
    
    /**
     * Finds the minimum, maximum and average time it took to sort an array for a specified algorithm.
     * 
     * @param results
     * @return <code>TimingResult</code>
     */
    private static TimingResult getTimingResult(List<Long> results) {
        long min = results.stream()
                .mapToLong(Long::longValue)
                .min()
                .getAsLong();
        
        long max = results.stream()
                .mapToLong(Long::longValue)
                .max()
                .getAsLong();
        
        long average = (long) results.stream()
                .mapToLong(Long::longValue)
                .average()
                .getAsDouble();
        
        return new TimingResult(min, max, average);
    }
    
    /**
     * Times how long the given sorting function takes to sort an array.
     * 
     * @param data
     * @param sort
     * @return <code>long</code>
     */
    private static long sortArray(int[] data, Consumer<int[]> sort) {
        long start = System.nanoTime();
        sort.accept(data);
        long end = System.nanoTime();

        return end - start;
    }

    /**
     * Creates three data arrays of a given size, one sequential ascending, sequential descending,
     * and random.
     * 
     * @param size
     * @return <code>List<int[]</code>
     */
    private static List<int[]> createDataArrays(int size) {
        int[] ascending = evaluator.createSequentialDataArrayAscending(size);
        int[] random = evaluator.createRandomDataArray(size);
        int[] descending = evaluator.createSequentialDataArrayDescending(size);
        
        return Arrays.asList(ascending, random, descending);
    }
    
    /**
     * Prints the results of timing into a table format.
     * 
     * @param selectionSortResult
     * @param insertionSortResult
     * @param mergeSortResult
     * @param size 
     */
    private static void printResults(List<Long> selectionSortResult, List<Long> insertionSortResult, List<Long> mergeSortResult, int size) {
        System.out.println(String.format("Data set of %d elements", size));
        System.out.println(String.format("%-15s | %-12s | %-12s | %-12s", "Sort Algorithm", "Min [s]", "Max [s]", "Average [s]"));
        System.out.println("-------------------------------------------------------------");
        System.out.println(String.format("%-15s | %s", "Selection", getTimingResult(selectionSortResult)));
        System.out.println(String.format("%-15s | %s", "Insertion", getTimingResult(insertionSortResult)));
        System.out.println(String.format("%-15s | %s", "Merge", getTimingResult(mergeSortResult)));
        System.out.println("");
    }
}
