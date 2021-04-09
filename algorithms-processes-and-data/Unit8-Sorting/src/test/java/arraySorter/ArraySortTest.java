package arraySorter;

import arrayGenerator.ArrayGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Define tests for array sorters.
 *
 * @param <T> The (Comparable) type of object in the arrays to be sorted.
 *
 * @author Hugh Osborne
 * @version October 2020
 */
abstract class ArraySortTest<T extends Comparable<? super T>> {
    /**
     * Get an array sorter to test.
     */
    public abstract ArraySort<T> getSorter();

    /**
     * Get an array generator of the required type.
     */
    public abstract ArrayGenerator<T> getGenerator();

    // The array in its sorted and unsorted versions are stored here.
    private T[] array; // the sorted/to be sorted array
    private T[] unsorted; // the array in its original unsorted state

    /**
     * Get an array of the specified size and sort it.
     *
     * @param size the size of the array to be sorted
     */
    private void getAndSortArray(int size) {
        array = getGenerator().getArray(size);
        unsorted = array.clone();
        getSorter().sort(array);
    }

    /**
     * Check that a sorter does not change the size of the array.
     *
     * @param size the size of array to be sorted.
     */
    public void testSorterSize(int size) {
        getAndSortArray(size);
        assertEquals(unsorted.length,array.length,"Sorted array and original array are not of the same size");
    }

    /**
     * Check that a sorter does not change the contents of the array.
     *
     * @param size the size of array to be sorted.
     */
    public void testSorterContents(int size) {
        getAndSortArray(size);
        HashMap<T,Integer> arrayCount = new HashMap<T,Integer>();
        HashMap<T,Integer> unsortedCount = new HashMap<T,Integer>();
        for (T entry: array) { // count entries in sorted array
            if (arrayCount.containsKey(entry)) {
                arrayCount.put(entry,arrayCount.get(entry)+1);
            } else {
                arrayCount.put(entry,1);
            }
        }
        for (T entry: unsorted) { // count entries in unsorted array
            if (unsortedCount.containsKey(entry)) {
                unsortedCount.put(entry,unsortedCount.get(entry)+1);
            } else {
                unsortedCount.put(entry,1);
            }
        }
        assertEquals(unsortedCount,arrayCount,"Sorted array and original array do not contain the same values");
    }

    /**
     * Check that the soorted array is sorted.
     *
     * @param size the size of array to be sorted.
     */
    public void testSorterSorted(int size) {
        getAndSortArray(size);
        for (int index = 1; index < array.length; index++) {
            if (array[index-1].compareTo(array[index]) > 0) {
                fail("The sorted array is not in ascending order.  Entries [" + (index-1) + "] (" + array[index-1] + ") and [" + index + "] (" + array[index] + ") are out of order.");
            }
        }
    }

    @Test
    public void testSize10() {
        testSorterSize(10);
    }

    @Test
    public void testSize100() {
        testSorterSize(100);
    }

    @Test
    public void testContents10() {
        testSorterContents(10);
    }

    @Test
    public void testContents100() {
        testSorterContents(100);
    }

    @Test
    public void testSorted10() {
        testSorterSorted(10);
    }

    @Test
    public void testSorted100() {
        testSorterSorted(100);
    }
}