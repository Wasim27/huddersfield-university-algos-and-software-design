package arrayGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A tester class for RandomListingGenerators.  This class inherits the array size and content tester methods  and tests
 * from ArrayGeneratorTest and ListingGeneratorTest and defines a new test method and some tests that perform basic
 * checks that the generated array is not sorted.
 *
 * There is definitely room for improvement in these tests.
 *
 * @author Hugh Osborne
 * @version September 2020
 */
abstract class RandomListingGeneratorTest extends ListingGeneratorTest {
    /**
     * Check that the contents of the generated array are not ordered.
     *
     * A lack of ordering is not a guarantee that an array is truly randomised, nor is the fact that an array is
     * sorted a guarantee that an incorrect randomising method has been applied.  There is therefore significant
     * room for improvement in this test method.
     *
     * The test should also not be applied to small generators, as the smaller the array, the greater the chance that
     * a "randomised" version of it will, in fact, be sorted.
     *
     * @param size the size of generator to be tested.
     */
    public void testRandom(int size) {
        ArrayGenerator generator = getGenerator(size); // get the generator to be tested
        for (int index = 1; index < generator.getSize(); index++) {
            if (generator.getArray()[index-1]>generator.getArray()[index]) {
                return; // pair out of order, so array is not sorted
            }
        }
        // no pairs out of order, so sorted
        fail("the array is sorted (this may not be an error, but if it keeps happening it almost certainly is)");
    }

    @Test
    public void testHundredRandom() {
        testRandom(100);
    }

    @Test
    public void testThousandRandom() {
        testRandom(1000);
    }

    @Test
    public void testMillionRandom() {
        testRandom(1000000);
    }
}