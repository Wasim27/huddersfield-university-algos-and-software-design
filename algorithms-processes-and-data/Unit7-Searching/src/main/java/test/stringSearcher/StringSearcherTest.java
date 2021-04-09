import org.junit.jupiter.api.Test;
import stringSearcher.NotFound;
import stringSearcher.StringSearcher;
import static org.junit.jupiter.api.Assertions.*;

abstract class StringSearcherTest {

    abstract StringSearcher stringSearcher(String string);

    private int searcherTest(String substring, String superstring) throws NotFound {
        return stringSearcher(substring).occursIn(superstring);
    }

    @Test
    void searchFred() throws NotFound {
        assertEquals(2, searcherTest("fred", "Alfred the great"));
    }

    @Test
    void searchCap() throws NotFound {
        assertEquals(6, searcherTest("cap", "The incapable captain capsized the boat"));
    }

    @Test
    void searchAbsent() throws NotFound {
        assertEquals(0, searcherTest("absent", "The cab sent a message to base"));
    }
}