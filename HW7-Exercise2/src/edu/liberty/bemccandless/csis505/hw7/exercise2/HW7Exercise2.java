package edu.liberty.bemccandless.csis505.hw7.exercise2;

/**
 *
 * @author bemccandless
 */
public class HW7Exercise2 {

    public static void main(String[] args) {
        IndexedList list = new IndexedList();
        list.print();
        
        list.insertInIndexedList("Albert");
        list.insertInIndexedList("Xena");
        list.insertInIndexedList("Claire");
        list.insertInIndexedList("Elijah");
        list.insertInIndexedList("Einstein");
        list.insertInIndexedList("Eric");
        list.insertInIndexedList("Isaiah");
        list.insertInIndexedList("Olivia");
        
        list.print();
        
        String result = list.searchIndexedList("Eric");
        
        if (result != null) {
            System.out.printf("'%s' was found%n", result);
        } else {
            System.out.printf("'%s' was not found%n", result);
        }

    }

}
