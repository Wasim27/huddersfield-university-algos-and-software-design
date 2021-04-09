package binaryTree;

/**
 * Use to report binary tree update operations that would destroy the ordering of tree they operate on.
 *
 * @author Hugh Osborne
 * @version October 2020
 */
public class TreeOrderException extends Exception {
    public TreeOrderException() {
        super("This operation would destroy the ordering on the tree.");
    }

    public TreeOrderException(String message) {
        super(message);
    }
}
