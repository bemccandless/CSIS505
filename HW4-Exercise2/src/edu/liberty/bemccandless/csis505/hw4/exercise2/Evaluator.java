package edu.liberty.bemccandless.csis505.hw4.exercise2;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * This class contains different sorting algorithms used to sort
 * data arrays into sequential order.
 * 
 * @author bemccandless
 */
public class Evaluator {

    public void selectionSortMcCandless(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i;
            for (int index = i + 1; index < data.length; index++) {
                if (data[index] < data[smallest]) {
                    smallest = index;
                }
            }
            
            swap(data, i, smallest);
        }
    }

    public void insertionSortMcCandless(int[] data) {
        for (int next = 1; next < data.length; next++) {
            int insert = data[next];
            int moveItem = next;
            
            while (moveItem > 0 && data[moveItem - 1] > insert) {
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }
            
            data[moveItem] = insert;
        }
    }

    public void mergeSortMcCandless(int[] data) {
        sortArray(data, 0, data.length - 1);
    }

    public int[] createSequentialDataArrayAscending(int size) {
        return IntStream.iterate(1, (i) -> ++i)
                .limit(size)
                .toArray();
    }

    public int[] createRandomDataArray(int size) {
        return IntStream.generate(new Random()::nextInt)
                .limit(size)
                .toArray();
    }

    public int[] createSequentialDataArrayDescending(int size) {
        return IntStream.iterate(size, (i) -> --i)
                .limit(size)
                .toArray();
    }
    
    private void sortArray(int[] data, int low, int high) {
        if ((high - low) >= 1) {
            int middle1 = (low + high) / 2;
            int middle2 = middle1 + 1;
            
            sortArray(data, low, middle1);
            sortArray(data, middle2, high);
            
            merge(data, low, middle1, middle2, high);
        }
    }
    
    private void merge(int[] data, int left, int middle1, int middle2, int right) {
        int leftIndex = left;
        int rightIndex = middle2;
        int combinedIndex = left;
        int[] combined = new int[data.length];
        
        while (leftIndex <= middle1 && rightIndex <= right) {
            if (data[leftIndex] <= data[rightIndex]) {
                combined[combinedIndex++] = data[leftIndex++];
            } else {
                combined[combinedIndex++] = data[rightIndex++];
            }
        }
        if (leftIndex == middle2) {
            while (rightIndex <= right) {
                combined[combinedIndex++] = data[rightIndex++];
            }
        } else {
            while (leftIndex <= left) {
                combined[combinedIndex++] = data[leftIndex++];
            }
        }

        for (int i = left; i <= right; i++) {
            data[i] = combined[i];
        }
    }
    
    private void swap(int[] data, int first, int second) {
        int temporary = data[first];
        data[first] = data[second];
        data[second] = temporary;
    }
}
