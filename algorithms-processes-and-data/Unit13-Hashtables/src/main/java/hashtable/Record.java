package hashtable;

/**
 * Models a record in a hashtable.
 *
 * @author Hugh Osborne
 * @version November 2020
 *
 * @param <K> the type of key used in these records
 * @param <V> the type of value stored in these records
 */

public class Record<K, V> {
    /**
     * This record's key.
     */
    K key;
    /**
     * This record's value.
     */
    V value;

    /**
     * Construct a record with the specified key and value.
     * @param key the record's key.
     * @param value the record's value.
     */
    protected Record(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Retrieve this record's key.
     * @return this record's key.
     */
    protected K getKey() {
        return key;
    }

    /**
     * Retrieve this record's value.
     * @return this record's value.
     */
    protected V getValue() {
        return value;
    }
}
