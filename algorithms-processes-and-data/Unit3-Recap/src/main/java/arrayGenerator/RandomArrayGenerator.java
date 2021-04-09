package arrayGenerator;

import java.util.Random;

/**
 * A simple array generator, that generates an array of random values.
 *
 * @author Hugh Osborne
 * @version September 2020
 */

public class RandomArrayGenerator implements ArrayGenerator {

    private int[] array;

    /**
     * Create an array of ints of size <tt>size</tt>, and populate it
     * with random values.
     *
     * @param size the size of the array to be created.
     * @param minimum the lower bound (inclusive) for the random values.
     * @param maximum the upper bound (exclusive) for the random values.
     */
    public RandomArrayGenerator(int size,int minimum,int maximum) {
        Random random = new Random(System.currentTimeMillis());
        array = new int[size];
        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(maximum-minimum)+minimum;
        }
    }

    @Override
    public int[] getArray() {
        return array;
    }

    @Override
    public int getSize() {
        return array.length;
    }
}
