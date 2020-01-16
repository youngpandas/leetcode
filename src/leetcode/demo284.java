package leetcode;

import java.util.Iterator;

public class demo284 {


class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    boolean isPeek = false;
    int val = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (isPeek) return val;
        isPeek = true;
        val = iterator.next();
        return val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (isPeek) {
            isPeek = false;
            return val;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (isPeek) return true;
        return iterator.hasNext();
    }
}

}
