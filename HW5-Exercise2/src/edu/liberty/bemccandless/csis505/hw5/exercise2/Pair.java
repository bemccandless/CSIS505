package edu.liberty.bemccandless.csis505.hw5.exercise2;

/**
 * Hold generic elements to make a generic pair object
 * 
 * @author bemccandless
 * @param <F> first element in a pair
 * @param <S> second element in a pair
 */
public class Pair<F, S> {
    
    private F firstElement;
    private S secondElement;

    public Pair() {
    }
    
    public Pair(F firstElement, S secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public F getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(F firstElement) {
        this.firstElement = firstElement;
    }

    public S getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(S secondElement) {
        this.secondElement = secondElement;
    }
    
    @Override
    public String toString() {
        return "Pair{" + "firstElement=" + firstElement + ", secondElement=" + secondElement + '}';
    }

}
