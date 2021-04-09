package searcher;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CleverRandomListingGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wasim Ramzan
 * @version October 2020
 */

class CleverSearcherTest extends SearcherTest {

    protected Searcher createSearcher(int[] array, int index) throws IndexingError {
        return new CleverSearcher(array, index);
    }

    private void withinRange(int arraySize, int index) throws IndexingError {
        ArrayGenerator generator = new CleverRandomListingGenerator(arraySize);
        CleverSearcher searcher = new CleverSearcher(generator.getArray(), index);
        assertTrue(index > 0 || index <= arraySize);     // true if within range (greater than 0 and less than equal to arraysize)
    }

    @Test
    void testMinus1In10() throws IndexingError {
        withinRange(10, -1);
    }

    @Test
    void test3In10() throws IndexingError {
        withinRange(10, 3);
    }

    @Test
    void test10001In10000() throws IndexingError {
        withinRange(10000, 10001);
    }

    @Test
    void test0In0() throws IndexingError {
        withinRange(0, 0);
    }

    @Test
    void test999999In1000000() throws IndexingError {
        withinRange(1000000, 999999);
    }

    @Test
    void testLargeNumber() throws IndexingError {
        withinRange(Integer.MAX_VALUE-1, Integer.MAX_VALUE-2);
    }
}