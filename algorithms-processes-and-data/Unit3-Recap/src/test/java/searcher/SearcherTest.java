package searcher;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CleverRandomListingGenerator;
import arrayGenerator.RandomArrayGenerator;
import org.junit.jupiter.api.Test;
import tools.Print;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Hugh Osborne
 * @version September 2018
 */

abstract class SearcherTest {

    /**
     * Create a searcher of the right type.  Each implementation of this abstract method should specify the exact
     * type of searcher that is returned.
     * @param array the array the searcher will search in.
     * @param index the index it will search for.
     * @return a searcher of the type to be used in the tests.
     * @throws IndexingError if the index is not within the bounds of the array.
     */
    abstract protected Searcher createSearcher(int[] array, int index) throws IndexingError;

    /**
     * Test that the searcher finds the correct value.  These tests use listings.  Since listings contain the values
     * 1, 2, ..., n-1 (possibly in a random order) the kth largest entry will always be n-k.
     * @param arraySize the size of the random listing to be generated (the "n" value)
     * @param index the index (the "k" value)
     * @throws IndexingError if k is out of bounds for n
     */
    private void testSearcher(int arraySize,int index) throws IndexingError {
        ArrayGenerator generator = new CleverRandomListingGenerator(arraySize);
        Searcher search = createSearcher(generator.getArray(), index);
        int expected = arraySize-index;
        int found = search.findElement();
        assertEquals(expected, found,"\n\tIncorrect " + Print.ordinal(index) + " largest value found by searcher in array " + Print.array(generator.getArray()) + " (array size " + arraySize + ")");
    }

    /**
     * Test a searcher on a random array.  These tests will assume that simple searchers return the correct value.
     * A simple searcher is used to retrieve this value, and this is compared to the value returned by the type of
     * searcher being tested.
     * @param arraySize the size of the random listing to be generated (the "n" value)
     * @param minimum the minimum (random) value to be used in the array (inclusive)
     * @param maximum the maximum (random) value to be used in the array (exclusive)
     * @param index the index (the "k" value)
     * @throws IndexingError if k is out of bounds for n
     */
    private void testRandom(int arraySize,int minimum,int maximum,int index) throws IndexingError {
        ArrayGenerator generator = new RandomArrayGenerator(arraySize,minimum,maximum);
        int[] array = generator.getArray();
        Searcher search = createSearcher(array, index);
        SimpleSearcher simpleSearch = new SimpleSearcher(array.clone(),index);
        int expected = simpleSearch.findElement();
        int found = search.findElement();
        assertEquals(expected, found,"\n\tIncorrect " + Print.ordinal(index) + " largest value found by searcher in array " + Print.array(generator.getArray()) + " (array size " + arraySize + ")");
    }

    @Test
    void test2ndIn10() throws IndexingError {
        testSearcher(10,2);
    }

    @Test
    void test5thIn10() throws IndexingError {
        testSearcher(10,5);
    }
    @Test
    void test3rdIn100() throws IndexingError {
        testSearcher(100,3);
    }

    @Test
    void test16thIn100() throws IndexingError {
        testSearcher(100,16);
    }

    @Test
    void test8thIn1000() throws IndexingError {
        testSearcher(1000,8);
    }

    @Test
    void test107thIn1000() throws IndexingError {
        testSearcher(1000,107);
    }

    @Test
    void test1stIn10000() throws IndexingError {
        testSearcher(10000,1);
    }

    @Test
    void test1003rdIn10000() throws IndexingError {
        testSearcher(10000,1003);
    }

    @Test
    void test11thIn100000() throws IndexingError {
        testSearcher(100000,11);
    }

    @Test
    void test4thIn1000000() throws IndexingError {
        testSearcher(1000000,4);
    }

    @Test
    void testRandom1() throws IndexingError {
        testRandom(10,0,20,3);
    }

    @Test
    void testRandom2() throws IndexingError {
        testRandom(100,-50,50,12);
    }

    @Test
    void testRandom3() throws IndexingError {
        testRandom(50,-200,-100,8);
    }
}