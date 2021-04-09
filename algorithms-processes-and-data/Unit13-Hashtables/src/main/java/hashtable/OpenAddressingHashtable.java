package hashtable;

import java.lang.reflect.Array;

/**
 * A partial implementation of hashtables, where address collisions are solved using open addressing.
 *
 * This abstract class defines many of the methods needed for open addressing, but does <i>not</i> implement the
 * {@link #getIndex(Object)}} and {@link #probe(int, int)} methods.
 *
 * Do <i>not</i> edit this file.  Any further implementation of this abstract class should be provided in a separate
 * (sub)class.
 *
 * @author Hugh Osborne
 * @version November 2020
 *
 * @param <K> the type of key used in this hashtable.
 * @param <V> the type of value to be stored in this hashtable.
 */
public abstract class OpenAddressingHashtable<K, V> implements HuddersfieldHashtable<K, V> {

    /**
     * The internal array for this hashtable.
     */
    Record<K, V>[] table;

    /**
     * Construct an open addressing hashtable with the specified
     * initial size.
     * @param size the (intial) size of the hash table
     */
    OpenAddressingHashtable(int size) {
        table = (Record<K, V>[]) Array.newInstance(new Record<K, V>(null,null).getClass(),size);
    }

    /**
     * Calculate an index in the hashtable for an entry with the given key.  Return the entry's
     * index if it exists.  If there is no such entry return the index of the
     * next free field, for this key, in the hashtable, using probing if needed.
     * @param key the key being looked for
     * @return the index of the entry with this key, if it exists or
     *         the address of the next free space if there is no such key in the table
     */
    protected abstract int getIndex(K key);

    /**
     * Find the next available index in the case of an address collision
     * @param index the initial index returned by the raw hash function
     * @param n the number of this attempt (how many times have we probed since the first index calculation)
     * @return the address specified by the probing function for this type of hashtable
     */
    protected abstract int probe(int index,int n);

    /**
     * Get the current size of the internal array.
     * @return the current size of the internal array.
     */
    int getInternalArraySize() {
        return table.length;
    }

    /**
     * Resize the internal array.  The new array will have a capacity of one more than twice the capacity of the old
     * array.
     */
    void resize() {
        Record<K, V>[] oldTable = table.clone(); // copy the old table
        table = (Record<K, V>[]) Array.newInstance(new Record<K, V>(null,null).getClass(),1+oldTable.length*2); // create a new table
        for (Record<K, V> record: oldTable) {
            insert(record.getKey(),record.getValue()); // copy all the entries to the new table
        }
    }
}
