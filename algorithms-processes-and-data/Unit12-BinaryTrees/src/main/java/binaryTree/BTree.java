package binaryTree;

import java.util.List;

/**
 * A minimum interface for sorted binary trees.
 *
 * @param <T> the type of value stored in the tree.
 *
 * @author Hugh Osborne.
 * @version October 2020.
 */
public interface BTree<T extends Comparable<? super T>> {

    /**
     * Check if the tree is empty.
     * @return true iff the tree is empty.
     */
    boolean isEmpty();

    /**
     * Insert a new value in the binary tree at a position determined by the current contents
     * of the tree, and by the ordering on the type T.
     * @param value the value to be inserted into the tree.
     * @return (for AVL trees) true iff the insertion caused the tree to become deeper.
     */
    boolean insert(T value);

    /**
     * Get the root node of the tree.
     * @return the tree's root node.
     */
    public TreeNode<T> getRoot();

    /**
     * Change this tree's root node.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * replacing the root node with the new root node would destroy the ordering of the tree.  If it would, the root
     * node is <i>not</i> replaced, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     * @param root the new root node for the tree.
     * @param safe should the update be done in safe mode?
     * @throws TreeOrderException if safe is true and replacing the root node would destroy the tree's ordering.
     */
    public void setRoot(TreeNode<T> root,boolean safe) throws TreeOrderException;

    /**
     * Get the value stored at the root of the tree.
     * @return the value stored at the root of the tree.
     * @throws NullPointerException if the tree is empty.
     */
    T getValue();
    // Note: it might make sense to define getValue() to throw a (custom) exception if an attempt
    // is made to access a value from an empty tree.
    // However, since a tree is empty iff its root node is null, it is also acceptable to rely
    // on Java's NullPointerException.
    // This comment also applies to the other get and set methods defined in this interface.

    /**
     * Change the value stored at the root of the tree.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * updating the root value to the new value would destroy the ordering of the tree.  If it would, the root value
     * is <i>not</i> updated, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     * @param value the new value to be stored at the root of the tree.
     * @param safe should the update be done in safe mode?
     * @throws TreeOrderException if safe is true and updating the tree would destroy its ordering.
     */
    void setValue(T value,boolean safe);

    /**
     * Get the left subtree of this tree.
     * @return  This tree's left subtree.
     * @throws NullPointerException if the tree is empty.
     */
    BTree<T> getLeft();

    /**
     * Change the left subtree of this tree.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * updating the left subtree to the new subtree would destroy the ordering of the tree.  If it would, the subtree
     * is <i>not</i> updated, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     * @param tree the new left subtree.
     * @param safe should the update be done in safe mode?
     * @throws TreeOrderException if safe is true and updating the tree would destroy its ordering.
     */
    void setLeft(BTree<T> tree,boolean safe);

    /**
     * Get the right subtree of this tree.
     * @return this tree's right subtree.
     * @throws NullPointerException if the tree is empty.
     */
    BTree<T> getRight();

    /**
     * Change the right subtree of this tree.
     * This setter method can operate in "safe" or "unsafe" mode.  In "safe" mode the method will check whether
     * updating the right subtree to the new subtree would destroy the ordering of the tree.  If it would, the subtree
     * is <i>not</i> updated, and a TreeOrderException is thrown.  In "unsafe" mode no such check is made.
     * @param tree the new right subtree.
     * @param safe should the update be done in safe mode?
     * @throws TreeOrderException if safe is true and updating the tree would destroy its ordering.
     */
    void setRight(BTree<T> tree,boolean safe);

    /**
     * Check if the tree contains a given value.
     * @param value the value to be checked.
     * @return true iff the value is in the tree.
     */
    boolean contains(T value);

    /**
     * Traverse the tree, producing a list of all the values contained in the tree.
     * @return a list of all the values in the tree.
     */
    List<T> inOrderTraversal();
}

