package hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenLinearHashtableTest extends OpenHashtableTest {

    @Override
    public OpenHashtable<String, Integer> getHashtable(int size) {
        return new OpenLinearHashtable(size);
    }
}