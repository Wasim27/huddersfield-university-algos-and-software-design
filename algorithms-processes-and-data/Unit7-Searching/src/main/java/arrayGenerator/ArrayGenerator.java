package arrayGenerator;

/**
 * Defines the interface for classes that generate arrays of arbitrary types
 * <p>
 * <i>This is an interface, and specifies the signature(s) of method(s) that
 * should be implemented in (a) <b>separate</b> class(es).</i>
 *
 * See the tester class for tests of this interface's properties.
 *
 * @param <T> the type of object in the arrays generated by this array generator.
 *
 * @author Hugh Osborne
 * @version October 2019
 */

public interface ArrayGenerator<T> {
    /**
     * Generate a random array.
     *
     * @param size the size of the array to be generated.
     * @return an array of the specified size containing elements of the specified type
     *
     * @throws NegativeArraySizeException if the size given is negative.
     */
    T[] getArray(int size) throws NegativeArraySizeException;
}
