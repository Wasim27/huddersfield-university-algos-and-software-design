package linkedList.list;

import linkedList.node.DoubleLinkNode;

/**
 * Implementation of a basic queue class using doubly linked lists.
 *
 * @param <T> the type of object to be stored in the queue.
 *
 * @author Hugh Osborne 
 * @version October 2019
 */
public class DoubleLinkQueue<T> extends BasicList<DoubleLinkNode<T>,T> implements Queue<T>
{
    /**
     * The last node in the queue.
     */
    DoubleLinkNode<T> tail;
    
    /**
     * Add a new value to the queue
     */
    public void enqueue(T value) {
        if (isEmpty()) { // if the queue is empty
            setRoot(new DoubleLinkNode<T>(value)); // create a new node, which will be the head (root) of the queue
            tail = getRoot(); // and which will also be the tail
        } else {
            DoubleLinkNode<T> oldHead = getRoot(); // make a note of the current head node
            setRoot(new DoubleLinkNode<T>(value,oldHead)); // create a new head, holding the required value. Its next pointer points to the old head
            oldHead.setPrevious(getRoot()); // set previous pointer of the old head to point to the new head
        }
        size++;
    }
    
    /**
     * Remove the oldest value from the queue
     * @return the oldest value in the queue
     * @throws ListAccessError if the queue is empty
     */
    public T dequeue() throws ListAccessError {
        if (isEmpty()) {
            throw new ListAccessError("Dequeue from an empty queue");
        }
        T result = tail.getValue(); // get the last value in the queue
        tail = tail.getPrevious(); // move tail to previous node
        if (tail != null) {
            tail.setNext(null); // and ensure that pointer to "removed" node is set to null
        } else {
            setRoot(null); // if tail is now null the queue is empty, so set head (root) to null as well
        }
        size--;
        return result;
    }

    /**
     * Populate this queue from an array.  If the queue is currently empty, the populated queue will be
     * equivalent to the array - it will contain exactly the same elements in the same order.  If the queue is
     * not initially empty the original elements of the queue will appear after the copy of the array.
     */
    public DoubleLinkQueue<T> fromArray(T[] array) throws ListAccessError {
        for (int index = array.length-1; index >= 0; index--) {
            enqueue(array[index]);
        }
        return this;
    }
}
