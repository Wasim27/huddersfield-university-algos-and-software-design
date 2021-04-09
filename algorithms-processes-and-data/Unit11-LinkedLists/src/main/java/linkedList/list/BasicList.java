package linkedList.list;

import linkedList.node.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Minimal implementation of list objects.
 *
 * Defines the root node, access methods, and test for emptiness.
 *
 * @param <N> the type of node used in this list (for example, single or double linked)
 * @param <T> the type of object stored in this list
 *
 * @author Hugh Osborne
 * @version October 2019
 */
public abstract class BasicList<N extends ListNode<T>,T> implements LinkedList<N,T> {

    /**
     * The root (or first) node in the list.
     * For stacks this is usually referred to as the "top", and for queues as the "head".
     */
    N root;

    /**
     * The number of elements in this list.
     */
    int size;

    /**
     * Is this list empty?
     *
     * @return (the list is empty)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the size of this list.
     * @return the number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Get the root node.
     *
     * @return the root node.
     */
    public N getRoot() {
        return root;
    }

    /**
     * Update the root node.
     *
     * @param newRoot the node that is to be the new root.
     */
    public void setRoot(N newRoot) {
        root = newRoot;
    }

    /**
     * Create an array equivalent to this list - i.e. with exactly the same elements in the same order.
     */
    public T[] toArray(Class<? extends T> cl) {
        T[] array = (T[]) Array.newInstance(cl,size());
        ListNode<T> node = getRoot();
        for (int index = 0; index < size(); index++) {
            array[index] = node.getValue();
            node = node.getNext();
        }
        return array;
    }

    /**
     * Get a String representation of this list.
     * @return a comma separated String list representation of this list.
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        } else {
            ListNode<T> currentNode = getRoot();
            StringBuilder string = new StringBuilder("[" + currentNode.getValue());
            while ((currentNode = currentNode.getNext()) != null) {
                string.append("," + currentNode.getValue());
            }
            string.append("]");
            return string.toString();
        }
    }

    /**
     * Get a String representation of this list, restricted to the first n elements of the list.
     * If the list contains more than n elements use ellipsis to indicate this.
     * @param n the maximum number of elements to incldue in the String.
     * @return a comma separated String list representation of this list.
     */
    public String toString(int n) {
        if (isEmpty()) {
            return "[]";
        } else {
            ListNode<T> currentNode = getRoot();
            StringBuilder string = new StringBuilder("[" + currentNode.getValue());
            int added = 0;
            while (added < n && (currentNode = currentNode.getNext()) != null) {
                string.append("," + currentNode.getValue());
                added++;
            }
            if (currentNode != null) {
                string.append(",...");
            }
            string.append("]");
            return string.toString();
        }
    }
}
