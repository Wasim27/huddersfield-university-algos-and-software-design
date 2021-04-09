package linkedList.list;

import linkedList.node.ListNode;
import linkedList.node.SingleLinkNode;

/**
 * A partial implementation of the List interface.
 * This implementation only implements the T get(int index) and SingleLinkList<T> formArray(T[] array) methods,
 * and the class must, therefore be declared abstract.
 * You should implement the remaining missing methods, so as to be able to make the class no longer abstract.
 *
 * @param <T> the type of object stored in the list.
 *
 * @author Hugh Osborne
 * @version October 2020
 */
public class SingleLinkList<T> extends BasicList<SingleLinkNode<T>,T> implements List<T> {

    /**
     * Populate this list from an array.  If the list is currently empty, the populated list will be
     * equivalent to the array - it will contain exactly the same elements in the same order.  If the list is
     * not initially empty the original elements of the list will appear after the copy of the array.
     */
    public SingleLinkList<T> fromArray(T[] array) throws ListAccessError {
        for (int index = array.length - 1; index >= 0; index--) {
            add(0, array[index]);
        }
        return this;
    }

    /**
     * A helper method to access a node at a specified index.
     *
     * @param index the index of the node to be accessed.
     * @throws ListAccessError if there is no node with the given index.
     */
    ListNode<T> getNode(int index) throws ListAccessError {
        // Is the list empty?  If so, cannot access the node.
        if (isEmpty()) {
            throw new ListAccessError("Cannot get node.  List is empty.");
        }
        // Is the given index negative?  If so, this is an error.
        if (index < 0) {
            throw new ListAccessError("Cannot get node.  Negative index.");
        }
        /*
         * Try to find the specified node by "walking" through the list, following links to successor
         * nodes.  The index tells us how many links need to be followed to reach the required node,
         * so reduce the index by one each time a link is followed.  When the index reaches zero, the
         * required node has been found.  If the end of the list is reached (next node is null), before
         * the index reaches zero, there were not enough nodes in the list (the index was too high).
         */
        ListNode<T> currentNode = getRoot(); // start at the root
        while (index != 0 && currentNode != null) { // walk along the list (if haven't reached the end by hitting null node)
            currentNode = currentNode.getNext(); // by gettting next node in the list
            index--; // and reducing index by one
        }
        // Reached the end of the list (by hitting null node)?  If so, cannot access the required node.
        if (currentNode == null) {
            throw new ListAccessError("Cannot get node.  Not enough nodes in the list.");
        }
        // Successfully found node by walking through until index was zero.
        return currentNode;
    }

    /**
     * Access the value at a given index.
     *
     * @param index the index of the value to be accessed.
     * @throws ListAccessError if there is no value with the given index.
     */
    public T get(int index) throws ListAccessError {
        return getNode(index).getValue();
    }

    /**
     * Add a new value to the list at position index
     *
     * @param index the index at which the new entry should be added.
     * @param value the value to be added.
     * @throws ListAccessError if index is an invalid index.
     */
    @Override
    public void add(int index, T value) throws ListAccessError {
        if (index < 0) {
            throw new ListAccessError("Index less than 0 (Out of Bounds)!");
        } else if (index > size) {
            throw new ListAccessError("Index greater than size!");
        }
        size++;

        if (index == 0) {
            setRoot(new SingleLinkNode<T>(value, getRoot()));
            return;
        }

        SingleLinkNode<T> previousNode = (SingleLinkNode<T>) getNode(index - 1);
        SingleLinkNode<T> newNode = new SingleLinkNode<T>(value, previousNode.getNext());
        previousNode.setNext(newNode);
    }


    /**
     * Remove a value from the list at the index specified.
     *
     * @param index the index of the entry to be removed.
     * @return the value removed.
     * @throws ListAccessError if index is an invalid index.
     */
    @Override
    public T remove(int index) throws ListAccessError {
        if (isEmpty()) {
            throw new ListAccessError("List is empty");
        }
        if (index < 0) {
            throw new ListAccessError("Index less than 0 (Out of bounds)!");
        } else if (index > size) {
            throw new ListAccessError("Index greater than size (Out of bounds)!");
        }

        SingleLinkNode<T> head = null;
        SingleLinkNode<T> tail = getRoot().getNext();
        T removedNode = get(index);

        if (index == 0) {
            setRoot(getRoot().getNext());
            size--;
            return removedNode;
        }

        head = getRoot();
        tail = tail.getNext();

        for (int i = 1; i < index; i++) {
            head = head.getNext();
            tail = tail.getNext();
        }

        head.setNext(tail);
        size--;
        return removedNode;
    }
}


