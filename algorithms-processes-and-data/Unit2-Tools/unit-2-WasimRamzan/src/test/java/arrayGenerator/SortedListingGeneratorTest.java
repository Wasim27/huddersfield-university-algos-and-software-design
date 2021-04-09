package arrayGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * A tester class for SortedListingGenerators.  This class inherits size and contents tests from ArrayGeneratorTest
 * and ListingGeneratorTest, and defines a method and some tests for testing that the contents are ordered.
 *
 * @author Hugh Osborne
 * @version September 2020
 */

class SortedListingGeneratorTest extends ListingGeneratorTest
{
    protected ArrayGenerator getGenerator(int size) {
        return new SortedListingGenerator(size); // make getGenerator return a SortedListingGenerator
    }

    /**
     * Check that the contents of the generated array are ordered.
     * @param size the size of generator to be tested.
     */
    public void testSorted(int size) {
        ArrayGenerator generator = getGenerator(size); // get the generator to be tested
        for (int index = 1; index < generator.getSize(); index++) {
            if (generator.getArray()[index-1]>=generator.getArray()[index]) {
                fail("Entries in listing are not sorted");
            }
        }
    }
    
    @Test
    public void testOneSorted() {
        testSorted(1);
    }

    @Test
    public void testTwoSorted() {
        testSorted(2);
    }

    @Test
    public void testFourSorted() {
        testSorted(4);
    }

    @Test
    public void testHundredSorted() {
        testSorted(100);
    }

    @Test
    public void testThousandSorted() {
        testSorted(1000);
    }

    @Test
    public void testMillionSorted() {
        testSorted(1000000);
    }
}