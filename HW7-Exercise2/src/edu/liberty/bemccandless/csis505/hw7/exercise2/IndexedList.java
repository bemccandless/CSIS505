package edu.liberty.bemccandless.csis505.hw7.exercise2;

/**
 * Used to create a self-referencing list of nodes
 */
class ListNode {

    String data;
    ListNode nextNode;
    ListNode nextIndexNode;

    ListNode(String object) { 
       this(object, null); 
    }  

    ListNode(String object, ListNode node) {
       data = object;    
       nextNode = node;  
    } 

    String getData() { 
       return data; 
    } 

    ListNode getNext() { 
       return nextNode; 
    } 
}

/**
 * A utility class for adding and searching for a listNode in an indexed list.
 */
public class IndexedList {
    
    private ListNode firstNode;
    private ListNode lastNode;
    private String name;

    public IndexedList() { 
        this("list"); 
    } 

    /**
     * Initialize and create indexed list
     * 
     * @param listName 
     */
    public IndexedList(String listName) {
        name = listName;
        createIndex();
    }
    
    /**
     * Search for a given value in the list
     * @param searchItem
     * @return search value if found, else null
     */
    public String searchIndexedList(String searchItem) {
        ListNode indexedNode = findNode(String.valueOf(searchItem.charAt(0)));
        while (indexedNode != null) {
            if (searchItem.equals(indexedNode.getData())) {
                return indexedNode.getData();
            }
            indexedNode = indexedNode.getNext();
        }
        
        return null;
    }

    /**
     * Insert a value into the indexed list
     * @param insertItem 
     */
    public void insertInIndexedList(String insertItem) {
        ListNode indexedNode = findNode(String.valueOf(insertItem.charAt(0)));
        if (indexedNode.nextNode == null) {
            indexedNode.nextNode = new ListNode(insertItem);
        } else {
            while (indexedNode.getNext() != null) {
                indexedNode = indexedNode.getNext();
            }
            indexedNode.nextNode = new ListNode(insertItem);
        }
    }

    /**
     * Print the indexed list
     */
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode current = firstNode;
        ListNode indexNode = firstNode;
        
        while (current != null) {
            System.out.printf("%s ", current.data);
            if (current.nextNode == null) {
                current = indexNode = indexNode.nextIndexNode;
            } else {
                current = current.nextNode;
            }
        }

        System.out.println();
    } 
    
    /**
     * Insert nodes in the back of list.  
     * Used to help create the indexes in the list
     * @param insertItem 
     */
    private void insertIndexAtBack(String insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(insertItem);
        } else {
            lastNode = lastNode.nextIndexNode = new ListNode(insertItem);
        }
    } 

    /**
     * Checks to see if the first node in the list is null.
     * @return boolean
     */
    private boolean isEmpty() { 
        return firstNode == null;
    } 
    
    /**
     * Find a node in the list for a given value.
     * Helps to find indexed node in the list
     * 
     * @param searchValue
     * @return 
     */
    private ListNode findNode(String searchValue) {
        ListNode currentNode = firstNode;
        while (currentNode.nextIndexNode != null) {
            if (currentNode.getData().equals(searchValue)) {
                return currentNode;
            } 
            currentNode = currentNode.nextIndexNode;
        }
        
        return null;
    }
    
    /**
     * Create an index node for each letter of the alphabet.  This helps to 
     * increase the speed of searching the indexed list.
     */
    private void createIndex() {
        String[] letters = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        
        for (String letter : letters) {
            insertIndexAtBack(letter);
        }
        
    }
}