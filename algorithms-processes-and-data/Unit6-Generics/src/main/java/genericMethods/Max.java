package genericMethods;

import java.util.Arrays;

/**
 * @author Wasim Ramzan
 * @version October 2020
 */

public class Max {

    /**
     * Returns largest string element within an array.
     * @param array the array in which to search.
     * @param index1 the index of the range to begin searching from.
     * @param index2 the index of the range to begin stop searching.
     * @param <T> the type of objects in the array.
     * @throws ArrayIndexOutOfBoundsException if either of the indices is out of bounds.
     */

    public static <T extends Comparable<T>> T max (T[] array, int index1, int index2) {
        T largest = array[index1];

        for(int i=index1; i<index2; i++) {
            if(largest.compareTo(array[i]) < 0 ) {
                largest = array[i];
            }
        } return largest;
    }

    public static void main(String[] args) {
        String [] names = {"Tony", "Andrew", "Hugh", "Diane", "Simon", "Gary"};
        System.out.println(Arrays.toString(names));
        System.out.println(max(names,1,4));
    }
}
