package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A partial implementation of sorted binary trees.
 * <p>
 * Five constructors (construct an empty tree ({@link #BinaryTree()}); or a tree with a root value but no subtrees
 * ({@link #BinaryTree(Comparable)}); or a tree with a root value and a left subtree, but with an empty right subtree
 * ({@link #BinaryTree(BTree, Comparable)}); or a tree with a root value and a right subtree, but with an empty left
 * subtree ({@link #BinaryTree(Comparable, BTree)}); or a complete tree, with a root value, and left and right subtrees
 * ({@link #BinaryTree(BTree, Comparable, BTree)}), as well as the {@link #isEmpty()} method are already implemented.
 * <p>
 * The getter methods ({@link #getRoot()}, {@link #getValue()}, {@link #getLeft()}, and  {@link #getRight()}) are also
 * implemented.
 * <p>
 * For the remaining methods specified in the {@link BTree} interface ({@link #insert(Comparable)},
 * {@link #setRoot(TreeNode, boolean)}, {@link #setValue(Comparable, boolean)},  {@link #setLeft(BTree, boolean)},
 * {@link #setRight(BTree, boolean)}, {@link #contains(Comparable)}, and {@link #inOrderTraversal()}) only a "stub" is
 * provided.  For the logbook exercise you should implement these methods.
 * <p>
 * Don't forget to test your implementation!
 *
 * @param <T> the type of value stored in the tree.
 * @author Hugh Osborne.
 * @version October 2020.
 */
public class BinaryTree<T extends Comparable<? super T>> implements BTree<T> {

    /**
     * The root node of this tree.
     */
    private TreeNode<T> root;

    /**
     * Construct an empty tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Construct a singleton tree.
     * A singleton tree contains a value in the root, but the left and right subtrees are
     * empty.
     *
     * @param value the value to be stored in the tree.
     */
    public BinaryTree(T value) {
        root = new TreeNode<>(value);
    }

    /**
     * Construct a binary tree with a left subtree and an empty right subtree.
     * Note: this constructor does <i>not</i> check that the constructed tree is ordered.
     *
     * @param left  the tree's left subtree.
     * @param value the tree's root value.
     */
    public BinaryTree(BTree<T> left, T value) {
        root = new TreeNode<T>(value, left, new BinaryTree<T>());
    }

    /**
     * Construct a binary tree with an empty left subtree and with a right subtree.
     * Note: this constructor does <i>not</i> check that the constructed tree is ordered.
     *
     * @param value the tree's root value.
     * @param right the tree's right subtree.
     */
    public BinaryTree(T value, BTree<T> right) {
        root = new TreeNode<T>(value, new BinaryTree<T>(), right);
    }

    /**
     * Construct a tree with a root value, and left and right subtrees.
     *
     * @param value the value to be stored in the root of the tree.
     * @param left  the tree's left subtree.
     * @param right the tree's right subtree.
     */
    public BinaryTree(BTree<T> left, T value, BTree<T> right) {
        root = new TreeNode<>(value, left, right);
    }

    /**
     * Check if the tree is empty.
     *
     * @return true iff the tree is empty.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     *
     * @param value the value to be inserted into the tree.
     * @return (for AVL trees) true iff the insertion caused the tree to become deeper.
     */
    public boolean insert(T value) {
        if (isEmpty()) {
            root = new TreeNode(value);
        } else if (value.compareTo(getValue()) < 0) {
            getLeft().insert(value);
        } else {
            getRight().insert(value);
        }
        return false;
    }

    /**
     * Get the root node of the tree.
     *
     * @return the tree's root node.
     */
    public TreeNode<T> getRoot() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return root;
    }

    /**
     * Change this tree's root node.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * replacing the root node with the new root node would destroy the ordering of the tree.  If it would, the root
     * node is <i>not</i> replaced, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     *
     * @param root the new root node for the tree.
     * @param safe should the update be done in safe mode?
     * @throws TreeOrderException if safe is true and replacing the root node would destroy the tree's ordering.
     */
    public void setRoot(TreeNode<T> root, boolean safe) throws TreeOrderException {
        if (safe == true) {
            throw new TreeOrderException();
        } else {
            setRoot(root, false);
        }
    }

    /**
     * Get the value stored at the root of the tree.
     *
     * @return the value stored at the root of the tree.
     * @throws NullPointerException if the tree is empty.
     */
    public T getValue() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            return root.getValue();
        }
    }

    /**
     * Change the value stored at the root of the tree.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * updating the root value to the new value would destroy the ordering of the tree.  If it would, the root value
     * is <i>not</i> updated, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     *
     * @param value the new value to be stored at the root of the tree.
     * @param safe  should the update be done in safe mode?
     * @throws TreeOrderException if safe is true and updating the tree would destroy its ordering.
     */
    public void setValue(T value, boolean safe) throws NullPointerException {
        root.setValue(value);
    }

    /**
     * Get the left subtree of this tree.
     *
     * @return This tree's left subtree.
     * @throws NullPointerException if the tree is empty.
     */

    public BTree<T> getLeft() throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException();
        } else {
            return root.getLeft();
        }
    }

    /**
     * Change the left subtree of this tree.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * updating the left subtree to the new subtree would destroy the ordering of the tree.  If it would, the subtree
     * is <i>not</i> updated, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     *
     * @param tree the new left subtree.
     * @param safe should the update be done in safe mode?
     */
    public void setLeft(BTree<T> tree, boolean safe) throws NullPointerException {
        root.setLeft(tree);
    }

    /**
     * Get the right subtree of this tree.
     *
     * @return this tree's right subtree.
     */
    public BTree<T> getRight() throws NullPointerException {
        return root.getRight();
    }

    /**
     * Change the right subtree of this tree.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * updating the right subtree to the new subtree would destroy the ordering of the tree.  If it would, the subtree
     * is <i>not</i> updated, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     *
     * @param tree the new right subtree.
     * @param safe should the update be done in safe mode?
     * @throws TreeOrderException if safe is true and updating the tree would destroy its ordering.
     */
    public void setRight(BTree<T> tree, boolean safe) {
        root.setRight(tree);
    }

    /**
     * Check if the tree contains a given value.
     *
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    public boolean contains(T value) throws NullPointerException {
        if (isEmpty()) {
            throw new NullPointerException("Tree Empty");
        } else if (getValue().equals(value)) {
            return true;
        } else if (value.compareTo(getValue()) < 0) {
            return getLeft().contains(value);
        } else if (value.compareTo(getValue()) > 0) {
            return getRight().contains(value);
        }
        return false;
    }

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     *
     * @return a list of all the values in the tree.
     */

    public List<T> inOrderTraversal() throws NullPointerException {
        ArrayList<T> list = new ArrayList<>();
        if (!getLeft().isEmpty()) {
            list.addAll(getLeft().inOrderTraversal());
        }
        list.add(getValue());

        if (!getRight().isEmpty()) {
            list.addAll(getRight().inOrderTraversal());
        }
        return list;
    }

    /**
     * Represent the tree as a String, in such a way that, when printed, the String will reflect the structure of the
     * tree.
     *
     * @return a String representation of the tree.
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        buildString(0, string); // build up the string, starting at depth zero
        return string.toString();
    }

    private void buildString(int depth, StringBuilder string) {
        if (isEmpty()) {
            addToString(depth, string, "*");
        } else {
            ((BinaryTree<T>) getRight()).buildString(depth + 1, string);
            addToString(depth, string, "" + getValue());
            ((BinaryTree<T>) getLeft()).buildString(depth + 1, string);
        }
    }

    private void addToString(int depth, StringBuilder string, String add) {
        for (int d = 0; d < depth; d++) {
            string.append("     ");
        }
        string.append(add);
        string.append("\n");
    }

    public static void main(String[] args) {
        BinaryTree<String> tree = new BinaryTree<String>();
        tree.insert("my");
        tree.insert("favourite");
        tree.insert("2020/21");
        tree.insert("module");
        tree.insert("is");
        tree.insert("algorithms");
        tree.insert("processes");
        tree.insert("and");
        tree.insert("data");
        System.out.println(tree.toString());
    }
}

