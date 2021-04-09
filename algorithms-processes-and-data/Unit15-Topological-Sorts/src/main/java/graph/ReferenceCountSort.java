package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Perform a reference count topological sort on a graph.
 *
 * @author Wasim Ramzan
 * @version November 2020
 */

public class ReferenceCountSort<T> extends AdjacencyGraph<T> implements TopologicalSort<T> {

    private HashMap<T, Integer> referenceCount = new HashMap<>();
    private ArrayList<T> sort = new ArrayList<>();

    @Override
    public List<T> getSort() throws GraphError {
        for (T node : getNodes()) {
            referenceCount.put(node, 0);
        }

        for (T node : getNodes()) {
            for (T neighbour : getNeighbours(node)) {
                increaseReferenceCount(neighbour);
            }
        }

        while (referenceCount.keySet().size() != 0) {
            boolean findPredecessor = false;

            for (T node : (T[]) referenceCount.keySet().toArray()) {
                if (referenceCount.get(node) == 0) {
                    sort.add(node);

                    for (T neighbour : getNeighbours(node)) {
                        referenceCount.replace(neighbour, (referenceCount.get(neighbour) - 1));
                    }
                    referenceCount.remove(node);
                    findPredecessor = true;
                }
            }

            if (!findPredecessor) {
                throw new GraphError("Cannot get topological sort. Graph is not acyclic.");
            }
        }
        return sort;
    }

    private void increaseReferenceCount(T neighbour) {
        Integer count = referenceCount.get(neighbour);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        referenceCount.put(neighbour, count);
    }
}



