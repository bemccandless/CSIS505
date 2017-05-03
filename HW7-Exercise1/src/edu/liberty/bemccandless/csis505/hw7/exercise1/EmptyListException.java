package edu.liberty.bemccandless.csis505.hw7.exercise1;

public class EmptyListException extends RuntimeException {

    public EmptyListException() {
        this("List");
    } 

    public EmptyListException(String name) {
        super(name + " is empty");
    } 
}