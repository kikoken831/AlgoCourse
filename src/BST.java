import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        this.root = addHelper(this.root,data);
    }

    //recursive helper method for adding in a BST using pointer reinforcement
    private BSTNode<T> addHelper(BSTNode<T> node, T data) {
        if(node == null) {
            this.size++;
            return new BSTNode<T>(data);
        }
        if(data.compareTo(node.getData()) < 0) {
            node.setLeft(addHelper(node.getLeft(), data));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRight(addHelper(node.getRight(), data));
        }
        return node;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        BSTNode<T> dummy = new BSTNode<T>(null);
        this.root = removeHelper(this.root, data, dummy);
        return dummy.getData();
    }

    private BSTNode<T> removeHelper(BSTNode<T> node, T data, BSTNode<T> dummy) {

        if(node == null) {
            throw new NoSuchElementException("Data is not in the tree");
        } else if(data.compareTo(node.getData()) < 0) {
            node.setLeft(removeHelper(node.getLeft(), data, dummy));
        } else if(data.compareTo(node.getData()) > 0) {
            node.setRight(removeHelper(node.getRight(), data, dummy));
        } else {
            dummy.setData(node.getData());
            if(node.getLeft() == null && node.getRight() == null) {
                this.size--;
                return null;
            } else if(node.getLeft() == null) {
                this.size--;
                return node.getRight();
            } else if(node.getRight() == null) {
                this.size--;
                return node.getLeft();
            } else {
                BSTNode<T> dummy2 = new BSTNode<T>(null);
                T predecessor = getPredecessor(node.getLeft());
                node.setData(predecessor);
                node.setLeft(removeHelper(node.getLeft(), predecessor, dummy2));

            }
        }
        return node;
    }

    private T getSuccessor(BSTNode<T> node) {
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    private T getPredecessor(BSTNode<T> node) {
        while(node.getRight() != null) {
            node = node.getRight();
        }
        return node.getData();
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }



    public ArrayList toArrayList() {
        ArrayList<T> list = new ArrayList<T>();
        toArrayListHelper(root, list);
        return list;
    }

    private void toArrayListHelper(BSTNode<T> node, ArrayList<T> list) {
        if(node == null) {
            return;
        }
        toArrayListHelper(node.getLeft(), list);
        list.addToBack(node.getData());
        toArrayListHelper(node.getRight(), list);
    }

    public T get(T data) {
        if(data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        return getHelper(this.root, data);
    }

    private T getHelper(BSTNode<T> root, T data) {
        if(root == null) {
            throw new NoSuchElementException("Data is not in the tree");
        }
        if(data.compareTo(root.getData()) < 0) {
            return getHelper(root.getLeft(), data);
        } else if(data.compareTo(root.getData()) > 0) {
            return getHelper(root.getRight(), data);
        } else {
            return root.getData();
        }
    }
}//18 9 43 null 14 null 74 null null null null null null 57 89