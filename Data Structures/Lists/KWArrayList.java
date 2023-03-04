package Lists;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class KWArrayList<E> extends AbstractList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private E[] theData;
    private int size = 0;
    private int capacity = 0;

    // No parameter - uses initial capacity of ArrayList
    public KWArrayList() {
        this.capacity = INITIAL_CAPACITY;
        this.theData = (E[]) new Object[this.capacity];
    }

    // Sets capacity of ArrayList
    public KWArrayList(int capacity) {
        this.capacity = capacity;
        this.theData = (E[]) new Object[this.capacity];
    }

    // Users wants to use an existing ArrayList
    public KWArrayList(Collection<? extends E> c) {
        this.addAll(c);
    }

    // Adds at the end
    @Override
    public boolean add(E anEntry) {
        if (this.size == this.capacity) {
           reallocate();
        }
        this.theData[this.size] = anEntry;
        this.size++;
        return true;
    }

    // Adds at the specific index
    @Override
    public void add(int index, E anEntry) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: " + index);
        }
        if (this.size == this.capacity) {
            reallocate();
        }
        for (int i = this.size; i > index; i--) {
            this.theData[i] = this.theData[i-1];
        }
        this.theData[index] = anEntry;
        this.size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: " + index);
        }
        return this.theData[index];
    }

    @Override
    public E set(int index, E anEntry) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: " + index);
        }
        E oldValue = this.theData[index];
        this.theData[index] = anEntry;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: " + index);
        }
        E returnValue = this.theData[index];
        for (int i = index + 1; i < this.size; i++) {
            this.theData[i-1] =  this.theData[i];
        }
        this.size--;
        return returnValue;
    }

    private void reallocate() {
        this.capacity = 2 * this.capacity;
        this.theData = Arrays.copyOf(this.theData, this.capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < this.size; i++) {
            if (this.theData[i] == null && item == null) {
                return i;
            }
            if (this.theData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
