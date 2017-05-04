package edu.liberty.bemccandless.csis505.hw7.exercise2;

class ListNode {

    String data;
    ListNode nextNode;
    ListNode indexNode;

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

public class IndexedList {
    
    private ListNode firstNode;
    private ListNode lastNode;
    private String name;

    public IndexedList() { 
        this("list"); 
    } 

    public IndexedList(String listName) {
        name = listName;
        createIndex();
    }
    
    public String searchIndexedList(String searchItem) {
        ListNode indexedNode = findNode(String.valueOf(searchItem.charAt(0)));
        while (indexedNode.nextNode != null) {
            if (searchItem.equals(indexedNode.getData())) {
                return indexedNode.getData();
            }
            indexedNode = indexedNode.getNext();
        }
        
        return null;
    }

    public void insertInIndexedList(String insertItem) {
        ListNode indexedNode = findNode(String.valueOf(insertItem.charAt(0)));
        if (indexedNode.nextNode == null) {
            indexedNode.nextNode = new ListNode(insertItem);
        } else {
            while (insertItem.equals(indexedNode.getNext().getData())) {
                indexedNode = indexedNode.getNext();
            }
            indexedNode.nextNode = new ListNode(insertItem, indexedNode.indexNode);
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        ListNode current = firstNode;

        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    } 
    
    private void insertAtFront(String insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(insertItem);
        } else {
            firstNode = new ListNode(insertItem, firstNode);
        }
    } 
    
    private void insertIndexAtBack(String insertItem) {
        if (isEmpty()) {
            firstNode = lastNode = new ListNode(insertItem);
        } else {
            lastNode = lastNode.indexNode = lastNode.nextNode = new ListNode(insertItem);
        }
    } 

    private boolean isEmpty() { 
        return firstNode == null;
    } 
    
    private ListNode findNode(String searchValue) {
        ListNode currentNode = firstNode;
        while (currentNode.nextNode != null) {
            if (currentNode.getData().equals(searchValue)) {
                return currentNode;
            } 
            currentNode = currentNode.nextNode;
        }
        
        return null;
    }
    
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