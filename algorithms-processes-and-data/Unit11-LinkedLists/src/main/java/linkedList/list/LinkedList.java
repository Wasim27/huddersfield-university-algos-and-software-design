package linkedList.list;

import linkedList.node.ListNode;

/**
 * Basic interface for linear lists.
 * This interface will be extended to define stacks, queues and lists
 * 
 * @author Hugh Osborne 
 * @version October 2019
 *
 * @param <T> the type of object in this list
 * @param <N> the type of node used in this list
 */

public interface LinkedList<N extends ListNode<T>,T>
{
    /**
     * Report if the list is empty
     * @return (list is empty)
     */
    public boolean isEmpty();

    /**
     * Get the size of this list.
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * Get a String representation of this list.
     * @return a comma separated String list representation of this list.
     */
    public String toString();

    /**
     * Create an array equivalent to this list - i.e. with exactly the same elements in the same order.
     */
    public T[] toArray(Class<? extends T> cl);

    /**
     * Populate this list from an array.  If the list is currently empty, the populated list will be
     * equivalent to the array - it will contain exactly the same elements in the same order.  If the list is
     * not initially empty the original elements of the list will appear after the copy of the array.
     */
    public LinkedList<N,T> fromArray(T[] array) throws ListAccessError;
}
