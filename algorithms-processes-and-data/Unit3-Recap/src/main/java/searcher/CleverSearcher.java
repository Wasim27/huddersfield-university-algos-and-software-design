package searcher;

import java.util.Arrays;

/**
 * @author Wasim Ramzan
 * @version October 2020
 * CleverSearcher implemented, finds kth largest element in array of ints.
 */
public class CleverSearcher extends Searcher {
    public CleverSearcher(int[] array, int k) throws IndexingError {
        super(array, k);
    }

    /**
     * Find the kth largest element in an array of ints using the "clever"
     * solution from the lecture.
     *
     * <ul>
     *     <li> Create a "helper" array of size k</li>
     *     <li> Sort the helper array</li>
     *     <li> for all the remaining elements of the original array
     *          <ul>
     *              <li> if it's smaller than the smallest element of the helper array, ignore it</li>
     *              <li> otherwise
     *                  <ul>
     *                      <li>throw away the smallest entry in the helper array</li>
     *                      <li>slot the new value into the helper array, maintaining that array's ordering</li>
     *                  </ul>
     *          </ul></li>
     *     <li> Return the smallest entry in the helper array</li>
     * </ul>
     *
     * @return kth largest element of array
     */
    public int findElement() throws IndexingError {
        int[] array = getArray();               // original array
        int k = getIndex();
        int[] smallArray = new int[k];          // helper array for the Kth largest elements

        if (k <= 0 || k > array.length) {       // check index is within bounds
            throw new IndexingError();
        }

        for(int i = 0; i < k; i++){
            smallArray[i] = array[i];           // copies current array elements to the small array
        }
        Arrays.sort(smallArray);                // sort small array

        for(int i = k; i < array.length; i++){
            if(array[i] > smallArray[0]){       // checks if number in large array is greater than index 0 in small array
                smallArray[0] = array[i];       // replace new larger element with the smallest in small array
                Arrays.sort(smallArray);        // sort small array again
            }
        }
        return smallArray[0];
    } // end of clever solution method
}
