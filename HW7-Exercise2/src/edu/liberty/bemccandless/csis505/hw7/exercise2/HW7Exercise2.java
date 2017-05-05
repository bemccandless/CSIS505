package edu.liberty.bemccandless.csis505.hw7.exercise2;

/**
 * Creates an indexed list to reduce the nodes that need to be checked when
 * searching for a given value.
 * 
 * @author bemccandless
 */
public class HW7Exercise2 {
    
    private static IndexedList list = new IndexedList();

    public static void main(String[] args) {
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
        
        findName("Eric");
        findName("Xena");
        findName("Frodo");
        findName("Einstein");
        
    }
    
    /**
     * Searches for given name in indexed list and outputs the result of 
     * whether of not the value is found.
     * 
     * @param name 
     */
    private static void findName(String name) {
        String result = list.searchIndexedList(name);
        
        if (result != null) {
            System.out.printf("'%s' was found%n", name);
        } else {
            System.out.printf("'%s' was not found%n", name);
        }
    }

}
