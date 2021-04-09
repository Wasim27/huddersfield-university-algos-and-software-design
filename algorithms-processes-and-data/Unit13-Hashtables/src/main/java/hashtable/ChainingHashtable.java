package hashtable;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A partial implementation of hashtables, where address collisions are solved using chaining.
 *
 * This abstract class only defines the constructor for chaining hashtables.
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
public abstract class ChainingHashtable<K, V> implements HuddersfieldHashtable<K, V> {
    /**
     * The hash table consists of an array of ArrayLists in which we can store
     * our data.
     */
    protected ArrayList<Record<K, V>>[] table; // the hashtable

    /**
     * Construct a new hashtable with the specified initial size
     * @param size the initial size of the hashtable
     */
    public ChainingHashtable(int size) {
        table = (ArrayList<Record<K, V>>[]) Array.newInstance(new ArrayList<Record<K, V>>().getClass(),size);
    }
}
