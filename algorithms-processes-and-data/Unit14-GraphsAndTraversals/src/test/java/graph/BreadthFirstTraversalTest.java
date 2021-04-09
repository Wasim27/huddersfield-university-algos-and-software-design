package graph;

/**
 * Tester class for breadth first traversals.
 *
 * @author Wasim Ramzan.
 * @version November 2020.
 */

public class BreadthFirstTraversalTest extends TraversalTest<BreadthFirstTraversal<Integer>> {
    @Override
    protected BreadthFirstTraversal<Integer> newTraversal() {
        return new BreadthFirstTraversal<Integer>();
    }
}
