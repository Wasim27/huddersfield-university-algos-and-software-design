package binaryTree;

import java.util.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

abstract class BinaryTreeTest<T extends Comparable<? super T>> {

    /*
     * Implementations should implement the createEntry() method, which is used to create objects of type T which can be
     * use to populate a tree.
     */
    protected abstract T createEntry();

    /**
     * The TestData class is used to store a binary tree and a list which should contain the same entries.
     * This makes it possible to test that the tree is of the right size, and does contain the expected entries.
     * Once the tree and list are populated, the tree is traversed, and the list is sorted.   The resulting
     * lists should be equal.
     */
    protected class TestData {
        BTree<T> tree;
        List<T> entries;
        List<T> traversal; // an in order traversal of the tree

        /**
         * Create a test data set of the specified size, by populating the tree and the data set with an identical
         * set of values.
         * @param size the size of the data set to be created.
         */
        protected TestData(int size) {
            tree = new BinaryTree<T>();
            entries = new ArrayList<T>();
            for (int i = 0; i < size; i++) {
                T entry = createEntry();
                entries.add(entry);
                tree.insert(entry);
            }
            traversal = tree.inOrderTraversal();
            entries.sort(Comparator.naturalOrder());
        }

        protected void testSize() {
            assertEquals(entries.size(),traversal.size(),"Tree (traversal) does not contain the right number of entries");
        }

        protected void testContents() {
            assertTrue(traversal.containsAll(entries),"Tree (traversal) does not contain all of the expected entries");
            assertTrue(entries.containsAll(traversal),"Tree (traversal) does not contains unexpected entries");
        }

        protected void testOrdered() {
            List<T> expected = new ArrayList<>(entries);
            expected.sort(Comparator.naturalOrder());
            assertArrayEquals(expected.toArray(),traversal.toArray(),"Tree traversal is not sorted");
        }
    }

    @Test
    public void testSmallSize() {
        new TestData(10).testSize();
    }

    @Test
    public void testMediumSize() {
        new TestData(100).testSize();
    }

    @Test
    public void testLargeSize() {
        new TestData(1000).testSize();
    }

    @Test
    public void testSmallContents() {
        new TestData(10).testContents();
    }

    @Test
    public void testMediumContents() {
        new TestData(100).testContents();
    }

    @Test
    public void testLargeContents() {
        new TestData(1000).testContents();
    }

    @Test
    public void testSmallOrdered() {
        new TestData(10).testOrdered();
    }

    @Test
    public void testMediumOrdered() {
        new TestData(100).testOrdered();
    }

    @Test
    public void testLargeOrdered() {
        new TestData(1000).testOrdered();
    }
}