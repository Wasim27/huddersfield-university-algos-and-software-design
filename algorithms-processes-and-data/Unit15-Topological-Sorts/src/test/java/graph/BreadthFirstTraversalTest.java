package graph;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester class for depth first traversals.
 *
 * @author Hugh Osborne.
 * @version November 2020.
 */
class BreadthFirstTraversalTest extends TraversalTest<BreadthFirstTraversal<Integer>> {
    @Override
    protected BreadthFirstTraversal<Integer> newTraversal() {
        return new BreadthFirstTraversal<>();
    }
}