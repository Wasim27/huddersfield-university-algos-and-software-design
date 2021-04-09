/**
 * A wrapper for the Hashtable class
 * 
 * @author Hugh Osborne 
 * @version October 2019
 *
 * @param <K> the type of key used in this hashtable.
 * @param <V> the type of value to be stored in this hashtable.
 */
public class HashtableWrapper<K,V> extends java.util.Hashtable<K,V>
{
    
    /**
     * Create a new hashtable of the specified size.
     * @param size the initial size of the hashtable's internal array.
     */
    public HashtableWrapper(int size) {
        super(size);
    }
    
    /**
     * Add a new record to the hashtable.
     * @param key the key agains which the record will be stored.
     * @param value the value to be stored in the record.
     * @return the value stored.
     */
    public V put(K key,V value) {
        return super.put(key,value);
    }
}
