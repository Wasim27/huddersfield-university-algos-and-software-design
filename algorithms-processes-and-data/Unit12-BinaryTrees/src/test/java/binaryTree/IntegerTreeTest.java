package binaryTree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerTreeTest extends BinaryTreeTest<Integer> {
    private static Random random = new Random(System.currentTimeMillis());

    @Override
    protected Integer createEntry() {
        return random.nextInt();
    }

    private BTree<Integer> buildTree() {
        BTree<Integer> node24 = new BinaryTree<Integer>(24);
        BTree<Integer> node15 = new BinaryTree<Integer>(15,node24);
        BTree<Integer> node39 = new BinaryTree<Integer>(39);
        BTree<Integer> node36 = new BinaryTree<Integer>(node15,36,node39);
        BTree<Integer> node56 = new BinaryTree<Integer>(56);
        BTree<Integer> node99 = new BinaryTree<Integer>(99);
        BTree<Integer> node81 = new BinaryTree<Integer>(node56,81,node99);
        BTree<Integer> root = new BinaryTree<Integer>(node36,42,node81);
        return root;
    }

    @Test
    public void testGetValue() {
        assertEquals(42,buildTree().getValue());
    }

    @Test
    public void testSetValue() {
        BTree<Integer> tree = buildTree();
        tree.setValue(132,false);
        assertEquals(132,tree.getValue(),"root value should have been updated to 132");
    }

    @Test
    public void testGetLeft() {
        Integer[] expected = {15,24,36,39};
        BTree<Integer> tree =  buildTree();
        Integer[] actual = tree.getLeft().inOrderTraversal().toArray(new Integer[0]);
        assertArrayEquals(expected,actual,"traversal of left subtree " + Arrays.toString(actual) + " does not match expected " + Arrays.toString(expected));
    }

    @Test
    public void testSetLeft() {
        Integer[] expected = {15,24,36,39,42,56,81,99};
        BTree<Integer> tree = buildTree();
        tree.setLeft(buildTree(),false);
        Integer[] actual = tree.getLeft().inOrderTraversal().toArray(new Integer[0]);
        assertArrayEquals(expected,actual,"traversal of left subtree after update " + Arrays.toString(actual) + " does not match expected " + Arrays.toString(expected));
    }

    @Test
    public void testGetRight() {
        Integer[] expected = {56,81,99};
        BTree<Integer> tree =  buildTree();
        Integer[] actual = tree.getRight().inOrderTraversal().toArray(new Integer[0]);
        assertArrayEquals(expected,actual,"traversal of right subtree " + Arrays.toString(actual) + " does not match expected " + Arrays.toString(expected));
    }

    @Test
    public void testSetRight() {
        Integer[] expected = {15,24,36,39,42,56,81,99};
        BTree<Integer> tree = buildTree();
        tree.setRight(buildTree(),false);
        Integer[] actual = tree.getRight().inOrderTraversal().toArray(new Integer[0]);
        assertArrayEquals(expected,actual,"traversal of right subtree after update " + Arrays.toString(actual) + " does not match expected " + Arrays.toString(expected));
    }

    @Test
    public void testContains() {
        assertTrue(buildTree().contains(81),"Tree does contain 81");
    }
}
