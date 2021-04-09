package arrayGenerator;

import java.util.Arrays; // in order to be able to use the fill(...) method

/**
 * Completes the implementation of random listing generator, using a simple randomising method.
 *
 * @author Hugh Osborne
 * @version September 2020
 */


public class SimpleRandomListingGenerator extends RandomListingGenerator {
    /**
     * Constructor.
     * @param size the size of the listing to be generated
     */
    public SimpleRandomListingGenerator(int size) {
        super(size);
    }

/**
 * Randomise the sorted array inherited from SortedListingGenerator (via RandomListingGenerator).
 */
    protected void randomise() {
        /*
         * The idea here is to create a new array of the same size, and then copy random entries from the original
         * array into the new array.  However, we don't want to create any duplicates, so we have to keep track of
         * entries that we have already used, and when picking a random entry, keep picking until we find one that we
         * haven't used yet.
         *
         * In pseudocode:
         *
         * create a new array of the same size as the original array;
         * for (each index in the new array) {
         *     do {
         *         pick a random entry in the original array;
         *     } until (you have picked an unused entry);
         *     copy that entry from the old array to the current index in the new array;
         * }
         * now overwrite the original array with the randomised array;
         *
         * We keep track of used entries by creating yet another array, this time of booleans, and of the same size
         * as the other two arrays.  An entry in this boolean array is true if the corresponding entry in the original
         * array has already been used, and false otherwise.
         */

        int[] copy = new int[getArray().length]; // create the copy array (will eventually contain the random listing)
        // used to indicate if elements have been used
        boolean[] used = new boolean[getArray().length]; // create the used array (have entries already been used?)
        Arrays.fill(used, false); // fill the used array with "false"s (no entries have yet been used)
        for (int index = 0; index < copy.length; index++) { // go through the copy array
            int randomIndex = getRandomIndex(); // pick a random index in the original array
            while (used[randomIndex]) { // if this index has already been used
                randomIndex = getRandomIndex(); // pick another one
            } // and try again
            copy[index] = getArray()[randomIndex]; // copy from the unused random index in the old array to the copy array
            used[randomIndex] = true; // and update used to show that this index has now been used
        }
        for (int index = 0; index < getArray().length; index++) { // now overwrite the original array with the random listing
            getArray()[index] = copy[index]; // by copying the values from the listing, one by one
        }
    }
}
