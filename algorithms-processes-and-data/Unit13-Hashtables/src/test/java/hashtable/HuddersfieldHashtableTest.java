package hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class HuddersfieldHashtableTest<H extends HuddersfieldHashtable<String,Integer>> {
    /**
     * Get a <String,Integer> hashtable of the specified initial size.
     * @param size the initial size of the hashtable.
     * @return an open addressing hashtable of the specified size.
     */
    public abstract H getHashtable(int size);

    protected H hashtable;

    @BeforeEach
    private void setUp() {
        hashtable = getHashtable(5);
        hashtable.insert("fred",37);
        hashtable.insert("is",69);
        hashtable.insert("dead",0);
        hashtable.insert("but",999);
    }

    @Test
    void testRetrieve()  {
        assertEquals(new Integer(69),hashtable.retrieve("is"));
    }

    @Test
    void testContainsKey() {
        assertTrue(hashtable.contains("dead"));
    }

    @Test
    void testContainsNotKey() {
        assertFalse(hashtable.contains("Hugh"));
    }

    @Test
    void testContainsKeyValue() {
        assertTrue(hashtable.contains("fred",37));
    }

    @Test
    void testContainsNotKeyValue() {
        assertFalse(hashtable.contains("Hugh",42));
    }

    @Test
    void testContainsKeyNotValue() {
        assertFalse(hashtable.contains("dead",6));
    }

    @Test
    void testDelete() {
        hashtable.delete("fred");
        assertFalse(hashtable.contains("fred"));

    }

    @Test
    void testInsert()  {
        assertFalse(hashtable.contains("hugh"));
        hashtable.insert("hugh",42);
        assertEquals(new Integer(42),hashtable.retrieve("hugh"));
    }

    @Test
    void testUpdate()  {
        assertEquals(new Integer(37),hashtable.retrieve("fred"));
        hashtable.insert("fred",42);
        assertEquals(new Integer(42),hashtable.retrieve("fred"));
    }


}