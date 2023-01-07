import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(root == null) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>();
        list.add(root.getData());
        list.addAll(preorder(root.getLeft()));
        list.addAll(preorder(root.getRight()));
        return list;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(root == null) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>();
        list.addAll(inorder(root.getLeft()));
        list.add(root.getData());
        list.addAll(inorder(root.getRight()));
        return list;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(root == null) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>();
        list.addAll(postorder(root.getLeft()));
        list.addAll(postorder(root.getRight()));
        list.add(root.getData());
        return list;
    }

    public List<T> levelorder(TreeNode<T> root) {
        if(root == null) {
            return new ArrayList<T>();
        }
        List<T> list = new ArrayList<T>();
        LinkedList<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode<T> node = queue.remove();
            list.add(node.getData());
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return list;
    }
}