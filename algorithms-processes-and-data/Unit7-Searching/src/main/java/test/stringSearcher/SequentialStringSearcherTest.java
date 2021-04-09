import stringSearcher.SequentialStringSearcher;
import stringSearcher.StringSearcher;

class SequentialStringSearcherTest extends StringSearcherTest {

    @Override
    StringSearcher stringSearcher(String string) {
        return new SequentialStringSearcher(string);
    }
}