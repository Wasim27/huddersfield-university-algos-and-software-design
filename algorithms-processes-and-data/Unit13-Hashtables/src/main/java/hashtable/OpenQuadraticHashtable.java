package hashtable;

/**
 * Completes the implementation of {@link OpenAddressingHashtable} that was partially implemented in
 * {@link OpenHashtable}, by implementing the {@link #probe(int, int)}} method.
 *
 * In this implementation quadratic probing is used.
 *
 * @author Wasim Ramzan
 * @version November 2020
 *
 * @param <K> the type of key used in this hashtable.
 * @param <V> the type of value to be stored in this hashtable.
 */

public class OpenQuadraticHashtable<K, V> extends OpenHashtable<K, V> {

    /**
     * Construct an open addressing hashtable with the specified
     * initial size.
     *
     * @param size the (initial) size of the hash table
     */

    OpenQuadraticHashtable(int size) {
        super(size);
    }

    /**
     * Perform the nth probe for a valid index into the hash table.
     * This implementation uses quadratic probing.
     * We are assuming constants c1 = 1, c2 = 0 and c3 = 0 so the probing has been simplified.
     * @param index the initial index returned by the raw hash function.
     * @param n the number of this attempt (how many times have we probed since the first index calculation).
     * @return index+n^2.
     */

    @Override
    protected int probe(int index, int n) {
        return ((index + n^2) % getInternalArraySize());
    }
}
