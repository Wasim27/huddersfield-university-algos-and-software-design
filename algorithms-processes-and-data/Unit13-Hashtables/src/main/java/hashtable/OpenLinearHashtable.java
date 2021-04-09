package hashtable;

/**
 * Completes the implementation of {@link OpenAddressingHashtable} that was partially implemented in
 * {@link OpenHashtable}, by implementing the {@link #probe(int, int)}} method.
 *
 * In this implementation linear probing is used.
 *
 * @author Hugh Osborne
 * @version October 2019
 *
 * @param <K> the type of key used in this hashtable.
 * @param <V> the type of value to be stored in this hashtable.
 */

public class OpenLinearHashtable<K, V> extends OpenHashtable<K, V> {

    /**
     * Construct an open addressing hashtable with the specified
     * initial size.
     *
     * @param size the (initial) size of the hash table
     */
    OpenLinearHashtable(int size) {
        super(size);
    }

    /**
     * Perform the nth probe for a valid index into the hash table.
     * This implementation uses linear probing.
     * @param index the initial index returned by the raw hash function.
     * @param n the number of this attempt (how many times have we probed since the first index calculation).
     * @return index+n.
     */
    @Override
    protected int probe(int index, int n) {
        return (index+n) % getInternalArraySize();
    }
}

