package arraySorter;

/**
 * The implementation of insertion sort from the lecture
 *
 * @author Hugh Osborne
 * @version October 2020
 */
public class InsertionSort<T extends Comparable<? super T>> implements ArraySort<T> {

    /**
     * Sort an array.
     *
     * @param array the array to be sorted.
     * @return the sorted array.
     */
    @Override
    public T[] sort(T[] array) {
        /*
         * Implements the sort using insertion sort:
         * for (the whole list is unsorted;
         *      there is still part of the list unsorted;
         *      one more element has been sorted) {
         *    take the first unsorted element;
         *    insert it into the correct position in the sorted part {
         *      gap is at first unsorted element's position;
         *      while (value to left of gap exists and < first unsorted element) {
         *        swap gap and value to the left of it;
         *      }
         *      put first unsorted element into gap;
         *    }
         * }
         */
        for (int sorted = 0;  // the whole list is unsorted, sorted part grows from start
             sorted < array.length-1; // stop when the whole list is sorted
             sorted++) { // one new element sorted each time round
            T firstUnsorted = array[sorted+1];
            int gapIndex = sorted+1;
            while (gapIndex > 0 && array[gapIndex - 1].compareTo(firstUnsorted) > 0) {
                T tmp = array[gapIndex];
                array[gapIndex] = array[gapIndex - 1];
                array[gapIndex - 1] = tmp;
                gapIndex--;
            }
            array[gapIndex] = firstUnsorted;
        }
        return array;
    }
}
