package arrayGenerator;

/**
 * A tester class for SortedListingGenerators.  This class inherits size and contents tests from ArrayGeneratorTest
 * and ListingGeneratorTest.
 *
 * @author Hugh Osborne
 * @version September 2020
 */

class SimpleRandomListingGeneratorTest extends RandomListingGeneratorTest{
    protected ArrayGenerator getGenerator(int size) {
        return new SimpleRandomListingGenerator(size); // make getGenerator return a SimpleRandomListingGenerator
    }
}