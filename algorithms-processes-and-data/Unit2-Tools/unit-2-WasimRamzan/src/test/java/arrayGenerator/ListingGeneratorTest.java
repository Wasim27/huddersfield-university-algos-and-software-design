package arrayGenerator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A tester class for ListingGenerators.  This class inherits the array size tester method  and tests from ArrayGeneratorTest,
 * and defines a new test method and some tests that check that the generated array does indeed contain the values 0..n-1.
 *
 * @author Hugh Osborne
 * @version September 2020
 */

abstract class ListingGeneratorTest extends ArrayGeneratorTest {

    /**
     * Test the contents of this listing.
     * A listing of size n <i>must</i> contain all of the values from 0 to n-1 (and each value muse, consequently,
     * appear exactly once).
     *
     * @param size the size of listing to be generated and tested.
     */
    public void testContents(int size) {
        ArrayGenerator generator = getGenerator(size); // get the generator to be tested

        boolean[] inList = new boolean[generator.getSize()]; // keep track of values we have already seen in the listing
        Arrays.fill(inList, false); // no values yet seen

        // Now check the entries
        for (int i = 0; i < generator.getSize(); i++) { // go through all the elements in the listing
            int entry = generator.getArray()[i];
            if (entry < 0 || entry >= generator.getSize()) { // if the entry is not between 0 and n-1
                fail("incorrect entry " + entry + " in array"); // fail
            }
            if (inList[i]) { // if the entry has already been seen
                fail(entry + " occurs more than once in array"); // fail
            }
            inList[i] = true; // mark the entry as seen
        }
        for (int i = 0; i < inList.length; i++) { // now check that all the expected entries have been seen
            if (!inList[i]) { // if this entry has not been seen
                fail(i + " is not in the array"); // fail
            }
        }
    }

    // Now defined some tests to test some listing contents

    @Test
    public void testOneContents() {
        testContents(1);
    }

    @Test
    public void testTwoContents() {
        testContents(2);
    }

    @Test
    public void testFourContents() {
        testContents(4);
    }

    @Test
    public void testHundredContents() {
        testContents(100);
    }

    @Test
    public void testThousandContents() {
        testContents(1000);
    }

    @Test
    public void testMillionContents() {
        testContents(1000000);
    }

}