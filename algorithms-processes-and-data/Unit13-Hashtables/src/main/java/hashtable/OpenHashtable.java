package hashtable;

/**
 * A partial implementation of hashtables, where address collisions are solved using open addressing.
 *
 * This abstract class defines all of the methods needed, except for {@link OpenAddressingHashtable#probe(int, int)}.
 *
 * @author Hugh Osborne
 * @version October 2019
 *
 * @param <K> the type of key used in this hashtable.
 * @param <V> the type of value to be stored in this hashtable.
 */

public abstract class OpenHashtable<K, V> extends OpenAddressingHashtable<K, V> implements HuddersfieldHashtable<K, V> {

    /**
     * Garbage marker
     */
    private final Record<K, V> GARBAGE;

    /**
     * Construct an open addressing hashtable with the specified
     * initial size.
     *
     * @param size the (intial) size of the hash table
     */
    OpenHashtable(int size) {
        super(size);
        GARBAGE = new Record<K, V>(null,null);
    }

    /**
     * Retrieve the index for a given key.
     * @param key the key being looked for.
     * @return the index of the occurrence of the key in this hashtable, if present, or the index of the first
     *         unused space for this key, as determined by the probing function.
     */
    @Override
    protected int getIndex(K key) {
        int initialIndex = key.hashCode() % table.length;  // get initial index
        for (int i = 0; i < table.length; i++) {  // probe until an unused entry is found
            // or until we've probed as many times as there are entries in
            // the array without finding an unused entry (in which case the
            // internal array is probably full).
            int index = probe(initialIndex,i);
            if (isUnused(table[index]) || table[index].getKey().equals(key)) {
                return index;
            }
        }
        resize(); // No unused entry in the internal array could be found, so resize it
        return getIndex(key); // and then try again.
    }

    /**
     * Insert a new entry into the hashtable, storing the data against the given key, or overwrite the data
     * already stored against this key, if it is already present.
     * @param key the key to be used to access the hash table
     * @param data the data to be inserted
     */
    @Override
    public void insert(K key, V data) {
        table[getIndex(key)] = new Record<>(key,data);
    }

    /**
     * Retrieve the data stored against the given key.
     * @param key the key to be used to retrieve the data.
     * @return the data stored agains the key.
     * @throws Error if the key is not present in the hashtable.
     */
    @Override
    public V retrieve(K key) throws Error {
        Record<K, V> entry = table[getIndex(key)];
        if (isUnused(entry)) {
            throw new Error("Cannot retrieve entry with key " + key + ".  No such entry.");
        }
        return entry.getValue();
    }

    /**
     * Delete the data stored agains the key.
     * @param key the key to be used to identify the data.
     * @return the deleted data.
     * @throws Error if the key is not present in the hashtable.
     */
    public V delete(K key) throws Error {
        int index = getIndex(key);
        if (isUnused(table[index])) {
            throw new Error("Cannot delete entry with key " + key + ".  No such entry.");
        }
        V value = table[index].getValue();
        table[index] = GARBAGE;
        return value;
    }

    /**
     * Check whether a given key is present in the hashtable.
     * @param key the key to be looked for.
     * @return true iff the key is present.
     */
    public boolean contains(K key) {
        int initialIndex = key.hashCode() % table.length;
        for (int i = 0; i < table.length; i++) {
            int index = probe(initialIndex,i);
            if (!isUnused(table[index]) && table[index].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether a given key/value pair is present in the hashtable.
     * @param key the key to be looked for.
     * @return true iff the key is present.
     */
    public boolean contains(K key, V value) {
        int initialIndex = key.hashCode() % table.length;
        for (int i = 0; i < table.length; i++) {
            int index = probe(initialIndex,i);
            if (!isUnused(table[index]) && table[index].getKey().equals(key) && table[index].getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a given record is unused.  A record is unused if it is null (no value has ever been entered in
     * this position), or if it is garbage (a previous entry has been deleted).
     * @param record the record to be checked.
     * @return true iff this record is unused and available for use.
     */
    private boolean isUnused(Record<K, V> record) {
        return record == null || record.equals(GARBAGE);
    }
}

