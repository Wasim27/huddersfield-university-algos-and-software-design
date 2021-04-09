package hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class OpenHashtableTest extends HuddersfieldHashtableTest<OpenHashtable<String,Integer>> {
    @Test
    void testSize() {
        assertEquals(5,hashtable.getInternalArraySize());
    }

    @Test
    void testEnlargedSize() {
        assertEquals(5,hashtable.getInternalArraySize());
        hashtable.insert("not",-42); // force the internal array to expand by
        hashtable.insert("me!",-1); // adding two more entries
        assertEquals(11,hashtable.getInternalArraySize());
    }
}