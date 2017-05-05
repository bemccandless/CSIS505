package edu.liberty.bemccandless.csis505.hw7.exercise1;

/**
 * Used to create a self-referencing list of nodes
 */
class ListNode<T> {

    T data;
    ListNode<T> nextNode;

    ListNode(T object) { 
       this(object, null); 
    }  

    ListNode(T object, ListNode<T> node) {
       data = object;    
       nextNode = node;  
    } 

    T getData() { 
       return data; 
    } 

    ListNode<T> getNext() { 
       return nextNode; 
    } 
}

/**
 * A utility class to add, delete and search for list nodes in a generic list.
 * 
 * @param <T> 
 */
public class List<T> {
    
    private ListNode<T> firstNode;
    private ListNode<T> lastNode;
    private ListNode<T> currentNode;
    private String name;

    /**
     * Constructor for list with a default name
     */
    public List() { 
        this("list"); 
    } 

    /**
     * Constructor for list with a provided name
     * 
     * @param listName 
     */
    public List(String listName) {
        name = listName;
        firstNode = lastNode = currentNode = null;
    } 

    /**
     * Find a given value in the generic list of nodes
     * 
     * @param searchValue
     * @return 
     */
    public T findItemRecursivelyMcCandless(T searchValue) {
        if (currentNode == null) {
            currentNode = firstNode;
        } else if (currentNode.nextNode == null) {
            currentNode = null;
            return null;
        } else {
            currentNode = currentNode.nextNode;
        }
        
        if (currentNode.getData().equals(searchValue)) {
            T dataFound = currentNode.getData();
            currentNode = null;
            
            return dataFound;
        } 
        
        return findItemRecursivelyMcCandless(searchValue);
    }

    /**
     * Insert a node to the front of the list
     * 
     * @param insertItem 
     */
    public void insertAtFront(T insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(insertItem);
        } else {
            firstNode = new ListNode(insertItem, firstNode);
        }
    } 

    /**
     * Insert a node to the back of the list
     * 
     * @param insertItem 
     */
    public void insertAtBack(T insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(insertItem);
        } else {
            lastNode = lastNode.nextNode = new ListNode(insertItem);
        }
    } 

    /**
     * Remove the node at the front of the list
     * 
     * @return
     * @throws EmptyListException 
     */
    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }

        T removedItem = firstNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        return removedItem;
    }

    /**
     * Remove the node at the back of the list
     * 
     * @return
     * @throws EmptyListException 
     */
    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }

        T removedItem = lastNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            ListNode<T> current = firstNode;

            while (current.nextNode != lastNode) {
                current = current.nextNode;
            }

            lastNode = current;
            current.nextNode = null;
        } 

        return removedItem;
    } 

    /**
     * Checks if the first node in the list is empty
     * 
     * @return 
     */
    public boolean isEmpty() { 
        return firstNode == null;
    } 

    /**
     * Prints the list
     */
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode<T> current = firstNode;

        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    } 
}