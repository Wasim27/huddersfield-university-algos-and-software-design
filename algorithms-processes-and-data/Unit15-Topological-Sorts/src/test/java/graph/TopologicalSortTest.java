package graph;

import arrayGenerator.IntegerArrayGenerator;
import org.junit.jupiter.api.Test;
import scope.IntegerScope;
import scope.TooSmall;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

abstract class TopologicalSortTest<T extends TopologicalSort<Integer>>  {
    Random random = new Random(System.currentTimeMillis());

    protected abstract T newSort();

    private void testContents(T graph, List<Integer> sort) {
        assertEquals(graph.getNodes().size(),sort.size(),"Graph and traversal are not the same size");
        assertTrue(sort.containsAll(graph.getNodes()),"The traversal does not contain all the nodes in the graph");
        assertTrue(graph.getNodes().containsAll(sort),"The traversal contains nodes not in the graph");
    }

    private void testOrdering(T graph,List<Integer> sort) throws GraphError {
        for (Integer node: graph.getNodes()) {
            for (Integer neighbour: graph.getNeighbours(node)) {
                if (sort.indexOf(node) > sort.indexOf(neighbour)) {
                    fail("Not a topological sort. There is an edge " + node + "==>" + neighbour + " but " + neighbour + " appears before " + node + " in the \"sort\"");
                }
            }
        }
    }

    private final static double // connectivity
            LOW = 0.1,
            INTERMEDIATE = 0.3,
            HIGH = 0.65;
    private final static int // size
            SMALL = 10,
            MEDIUM = 50,
            LARGE = 250;

    private T createGraph(int size, double connectivity) throws TooSmall, GraphError {
        Random random = new Random(System.currentTimeMillis());
        T graph = newSort();
        Integer[] array = new IntegerArrayGenerator(new IntegerScope(size,5*size)).getNoDuplicatesArray(size);
        Arrays.sort(array);
        for (Integer node: array) {
            graph.add(node);
        }
        for (int from = array.length-1; from > 0; from--) {
            for (int to = 0; to < from; to++) {
                if (random.nextDouble() < connectivity) {
                    graph.add(array[from],array[to]);
                }
            }
        }
        return graph;
    }

    private T generateCyclicGraph(int size) throws GraphError {
        T graph = newSort();
        for (int index = 0; index < size; index++) {
            graph.add(index);
        }
        for (int index = 0; index < size; index++) {
            graph.add(index,(index+1)%size);
        }
        return graph;
    }

    private T generatePairedGraph(int noOfPairs) throws GraphError {
        T graph = newSort();
        for (int low=0,high=2*noOfPairs;low < noOfPairs;low++,high--) {
            graph.add(low);
            graph.add(high);
            graph.add(low,high);
            graph.add(high,low);
        }
        return graph;
    }

    private void testCyclic(int size) throws GraphError {
        T graph = generateCyclicGraph(size);
        List<Integer> traversal = graph.getSort();
    }

    private void testPaired(int noOfPairs) throws GraphError {
        T graph = generatePairedGraph(noOfPairs);
        List<Integer> traversal = graph.getSort();
    }

    @Test
    public void testCompile() {

    }

    @Test
    public void testContentsSL() throws TooSmall, GraphError {
        T graph = createGraph(SMALL,LOW);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsSI() throws TooSmall, GraphError {
        T graph = createGraph(SMALL,INTERMEDIATE);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsSH() throws TooSmall, GraphError {
        T graph = createGraph(SMALL,HIGH);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsML() throws TooSmall, GraphError {
        T graph = createGraph(MEDIUM,LOW);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsMI() throws TooSmall, GraphError {
        T graph = createGraph(MEDIUM,INTERMEDIATE);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsMH() throws TooSmall, GraphError {
        T graph = createGraph(MEDIUM,HIGH);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsLL() throws TooSmall, GraphError {
        T graph = createGraph(LARGE,LOW);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsLI() throws TooSmall, GraphError {
        T graph = createGraph(LARGE,INTERMEDIATE);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testContentsLH() throws TooSmall, GraphError {
        T graph = createGraph(LARGE,HIGH);
        testContents(graph,graph.getSort());
    }

    @Test
    public void testOrderingSL() throws TooSmall, GraphError {
        T graph = createGraph(SMALL,LOW);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingSI() throws TooSmall, GraphError {
        T graph = createGraph(SMALL,INTERMEDIATE);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingSH() throws TooSmall, GraphError {
        T graph = createGraph(SMALL,HIGH);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingML() throws TooSmall, GraphError {
        T graph = createGraph(MEDIUM,LOW);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingMI() throws TooSmall, GraphError {
        T graph = createGraph(MEDIUM,INTERMEDIATE);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingMH() throws TooSmall, GraphError {
        T graph = createGraph(MEDIUM,HIGH);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingLL() throws TooSmall, GraphError {
        T graph = createGraph(LARGE,LOW);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingLI() throws TooSmall, GraphError {
        T graph = createGraph(LARGE,INTERMEDIATE);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testOrderingLH() throws TooSmall, GraphError {
        T graph = createGraph(LARGE,HIGH);
        testOrdering(graph,graph.getSort());
    }

    @Test
    public void testCyclicS() {
        assertThrows(GraphError.class,()->testCyclic(SMALL));
    }

    @Test
    public void testCyclicM() {
        assertThrows(GraphError.class,()->testCyclic(MEDIUM));
    }

    @Test
    public void testCyclicL() {
        assertThrows(GraphError.class,()->testCyclic(LARGE));
    }

    @Test
    public void testPairedS() {
        assertThrows(GraphError.class,()->testPaired(SMALL));
    }

    @Test
    public void testPairedM() {
        assertThrows(GraphError.class,()->testPaired(MEDIUM));
    }

    @Test
    public void testPairedL() {
        assertThrows(GraphError.class,()->testPaired(LARGE));
    }
}