package genericMethods;

import java.util.Arrays;

/**
 * @author Wasim Ramzan
 * @version October 2020
 */

public class Swap {

    /**
     * Swap two entries in an array.
     * @param array the array in which entries are to be swapped.
     * @param index1 the index of the first entry to be swapped.
     * @param index2 the index of the second entry to be swapped.
     * @param <T> the type of objects in the array.
     * @throws ArrayIndexOutOfBoundsException if either of the indices is out of bounds.
     */

     public static <T> void swap (T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
     }

    public static void main(String[] args) {
        String [] names = {"Tony", "Andrew", "Hugh", "Diane", "Simon", "Gary"};
        System.out.println("Before swap: " + Arrays.toString(names));
        swap(names,1,4);
        System.out.println("After swap: " + Arrays.toString(names));
    }
}
