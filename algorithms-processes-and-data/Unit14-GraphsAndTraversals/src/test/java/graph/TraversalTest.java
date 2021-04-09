package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester class for traversals.  All tests in this class are valid tests for both depth first and breadth first
 * traversals.  Full implementations of this abstract class may add further tests that are specific to the
 * particular traversal type they are testing.
 *
 * @param <T> the type of traversal to be tested.
 *
 * @author Hugh Osborne.
 * @version November 2020.
 */
abstract class TraversalTest<T extends Traversal<Integer>> {
    Random random = new Random(System.currentTimeMillis());

    protected abstract T newTraversal();

    private void testContents(T graph, List<Integer> traversal) throws GraphError {
        assertEquals(graph.getNodes().size(),traversal.size(),"Graph and traversal are not the same size");
        assertTrue(traversal.containsAll(graph.getNodes()),"The traversal does not contain all the nodes in the graph");
        assertTrue(graph.getNodes().containsAll(traversal),"The traversal contains nodes not in the graph");
    }

    private void testCyclicGraph(T graph,List<Integer> traversal) throws GraphError {
        if (graph.getNoOfNodes() == 0) return;
        int entry = traversal.get(0);
        for (int index = 1; index < traversal.size(); index++) {
            assertEquals((entry+1)%traversal.size(),traversal.get(index),"Traversal of a cyclic increasing graph does not contain increasing values");
            entry = traversal.get(index);
        }
    }

    private void testPairedGraph(T graph,List<Integer> traversal) throws GraphError {
        if (graph.getNoOfNodes() == 0) return;
        if (graph.getNoOfNodes()%2 != 0) fail("Graph does not contain an even number of nodes");
        for (int index = 0; index < traversal.size(); index += 2) {
            assertEquals(graph.getNoOfNodes(),traversal.get(index)+traversal.get(index+1),"Incorrect neighbouring values in paired graph");
        }
    }

    private T generateCyclicGraph(int size) throws GraphError {
        T graph = newTraversal();
        for (int index = 0; index < size; index++) {
            graph.add(index);
        }
        for (int index = 0; index < size; index++) {
            graph.add(index,(index+1)%size);
        }
        return graph;
    }

    private T generatePairedGraph(int noOfPairs) throws GraphError {
        T graph = newTraversal();
        for (int low=0,high=2*noOfPairs;low < noOfPairs;low++,high--) {
            graph.add(low);
            graph.add(high);
            graph.add(low,high);
            graph.add(high,low);
        }
        return graph;
    }

    // connectivity: probability of any edge being included.
    private T generateErdosRenyi(int size,double connectivity) throws GraphError {
        T graph = newTraversal();
        for (int index = 0; index < size; index++) {
            graph.add(index);
        }
        int possibleNoOfEdges = size*size; // directed graph
        for (int index = 0; index < possibleNoOfEdges*connectivity; index++) {
            int link = random.nextInt(possibleNoOfEdges);
            int from = link/size, to = link%size;
            if (!graph.contains(from,to)) {
                graph.add(from,to);
            }
        }
        return graph;
    }

    private void testCyclic(int size) throws GraphError {
        T graph = generateCyclicGraph(size);
        List<Integer> traversal = graph.traverse();
        testContents(graph,traversal);
        testCyclicGraph(graph,traversal);
    }

    private void testPaired(int noOfPairs) throws GraphError {
        T graph = generatePairedGraph(noOfPairs);
        List<Integer> traversal = graph.traverse();
        testContents(graph,traversal);
        testPairedGraph(graph,traversal);
    }

    private void testRandom(int size,double connectivity) throws GraphError {
        T graph = generateErdosRenyi(size,connectivity);
        List<Integer> traversal = graph.traverse();
        testContents(graph,traversal);

    }

    @Test
    void testEmpty() throws GraphError {
        testContents(newTraversal(),new ArrayList<Integer>());
    }

    @Test
    void testCyclic3() throws GraphError {
        testCyclic(3);
    }

    @Test
    void testCyclic10() throws GraphError {
        testCyclic(10);
    }

    @Test
    void testCyclic38() throws GraphError {
        testCyclic(38);
    }

    @Test
    void testCyclicRandom() throws GraphError {
        int size = random.nextInt(40)+10;
        testCyclic(size);
    }

    @Test
    void testPaired3() throws GraphError {
        testPaired(3);
    }

    @Test
    void testPaired10() throws GraphError {
        testPaired(10);
    }

    @Test
    void testPaired38() throws GraphError {
        testPaired(38);
    }

    @Test
    void testPairedRandom() throws GraphError {
        int size = random.nextInt(40)+10;
        testPaired(size);
    }

    @Test
    void testRandom3() throws GraphError {
        testRandom(3,0.4);
    }

    @Test
    void testRandom10() throws GraphError {
        testRandom(1,0.1);
    }

    @Test
    void testRandom38() throws GraphError {
        testRandom(38,0.1);
    }

    @Test
    void testRandomRandom() throws GraphError {
        int size = random.nextInt(40)+10;
        testRandom(size,0.1);
    }
}