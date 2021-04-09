package searcher;

/**
 * Use to report index out of bounds errors
 *
 * @author Hugh Osborne
 * @version September 2020
 **/
public class IndexingError extends Exception
{
    /**
     * Used to report an index out of bounds error
     **/
    IndexingError() {
        super("Index k out of bounds");
    }
}

