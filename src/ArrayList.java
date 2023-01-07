import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        this.checkSize();
        for (int i = size; i > 0; i--) {
            backingArray[i] = backingArray[i - 1];
        }
        this.backingArray[0] = data;
        this.size++;
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        this.checkSize();
        this.backingArray[this.size] = data;
        this.size++;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(this.size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        if(this.size == 1) {
            T temp = this.backingArray[0];
            this.backingArray[0] = null;
            this.size--;
            return temp;
        }
        T data = this.backingArray[0];
        //shift elements to the left
        for (int i = 0; i < this.size - 1; i++) {
            this.backingArray[i] = this.backingArray[i + 1];
        }
        this.backingArray[this.size - 1] = null;
        this.size--;
        return data;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(this.size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        if(this.size == 1) {
            T temp = this.backingArray[0];
            this.backingArray[0] = null;
            this.size--;
            return temp;
        }
        T data = this.backingArray[this.size - 1];
        this.backingArray[this.size-1] = null;
        this.size--;
        return data;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    //Checks if the backing array is full and doubles the size if it is
    private void checkSize() {
        if (this.size == this.backingArray.length) {
            T[] temp = (T[]) new Object[this.backingArray.length * 2];
            for (int i = 0; i < this.backingArray.length; i++) {
                temp[i] = this.backingArray[i];
            }
            this.backingArray = temp;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return this.backingArray[index];
    }

    /**
     * Adds the data to the specified index.
     *
     * Must be O(1) for index size and O(n) for all other cases.
     *
     * ASSUMPTIONS:
     * - You may assume that the backingArray will not need to be resized.
     * - You may assume that the index is valid [0, size].
     * - You may assume that the data will never be null.
     *
     * @param index the index at which to add the new data
     * @param data  the data to add at the specified index
     */
    public void addAtIndex(int index, T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        if (index == this.size) {
            this.backingArray[this.size] = data;
            this.size++;
        } else if (index == 0) {
            for (int i = size; i > 0; i--) {
                backingArray[i] = backingArray[i - 1];
            }
            this.backingArray[0] = data;
            this.size++;
        } else {
            for (int i = this.size; i > index; i--) {
                this.backingArray[i] = this.backingArray[i - 1];
            }
            this.backingArray[index] = data;
            this.size++;
        }
    }
}