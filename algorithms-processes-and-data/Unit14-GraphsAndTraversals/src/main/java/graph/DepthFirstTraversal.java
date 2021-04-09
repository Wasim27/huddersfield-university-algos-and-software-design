package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Stub class.  Implement breadth first traversals here.
 * @param <T> the type of node in the graph.
 *
 * @author Wasim Ramzan.
 * @version November 2020.
 */
public class DepthFirstTraversal<T> extends AdjacencyGraph<T> implements Traversal<T> {

    private List<T> traversal = new ArrayList<T>();

    @Override
    public List<T> traverse() throws GraphError {
        T node = getUnvisitedNode(); // get an unvisited node
        while (node != null) { // while there is at least one unvisited node
            visitNode(node);
            node = getUnvisitedNode(); // and then get another unvisited node
        }
        return traversal;
    }

    /**
     * Check if a node has been visited.
     * I.e. check if the node is
     * <ul>
     *   <li> in the traversal, having actually been visited
     * </ul>
     * @return this node has been visited
     */
    private boolean visited(T node) {
        return traversal.contains(node); // the node has been visited and is in the traversal
    }

    /**
     * Get the next "unvisited" node.  This method will actually also count nodes
     * @return a node that has not yet been visited or return null if no such node exists
     */
    private T getUnvisitedNode() {
        for (T node: getNodes()) { // check all the nodes
            if (!visited(node)) { // if this node has not been "visited"
                return node; // then this is an unvisited node
            }
        }
        // checked all nodes, and there are no unvisited nodes
        return null; // so return null
    }

    /**
     * Visit a node.
     * @throws GraphError if node is not a node in the graph
     */
    private void visitNode(T node) throws GraphError {
        if (visited(node)) return; // if the node is already visited do nothing
        traversal.add(node); // add the node to the traversal
        for (T neighbour: getNeighbours(node)) { // for all this node's neighbours
            if (!visited(neighbour)) // if the neighbour hasn't been visited
                visitNode(neighbour); // visit neighbour node
        }
    }
}
