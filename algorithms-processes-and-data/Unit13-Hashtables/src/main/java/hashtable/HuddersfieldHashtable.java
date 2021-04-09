package hashtable;

/**
 * Defines the interface for locally implemented hashtables.
 *
 * @author Hugh Osborne
 * @version November 2020
 *
 * @param <K> the type of key used in this hashtable.
 * @param <V> the type of value to be stored in this hashtable.
 */

public interface HuddersfieldHashtable<K, V> {

    /** This method should store the given data in the array at the position given by the
     *  key's hash code (taken modulo the table's size).
     *  @param key the key to be used to access the hash table.
     *  @param data the data to be inserted.
     */

    void insert(K key, V data);

    /**
     * This method should retrieve a value from a hash table.
     * @param key the key to be used to retrieve the object.
     * @return the object specified by the key, if it is present in the table, and <b>null</b> otherwise.
     */
    V retrieve(K key);

    /**
     * Delete the data stored against the key.
     * @param key the key to be used to identify the data.
     * @return the deleted data, or null if the key was not present.
     * @throws Error if the key is not present in the hashtable.
     */
    V delete(K key);

    /**
     * Check whether a given key is present in the hashtable.
     * @param key the key to be looked for.
     * @return true iff the key is present.
     */
    boolean contains(K key);

    /**
     * Check whether a given key/value pair is present in the hashtable.
     * @param key the key to be looked for.
     * @return true iff the key is present.
     */
    boolean contains(K key, V value);

}
