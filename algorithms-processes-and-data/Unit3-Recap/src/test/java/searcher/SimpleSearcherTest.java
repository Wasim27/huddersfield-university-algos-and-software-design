package searcher;

/**
 * @author Hugh Osborne
 * @version September 2020
 */

class SimpleSearcherTest extends SearcherTest {

    protected Searcher createSearcher(int[] array, int index) throws IndexingError {
        return new SimpleSearcher(array,index);
    }

}