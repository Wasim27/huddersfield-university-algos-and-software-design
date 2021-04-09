/**
 * This package defines an interface for graphs (in {@link graph.Graph}).  An implementation, using adjacency lists
 * (implemented using {@link java.util.Hashtable}s) is provided in {@link graph.AdjacencyGraph}.
 *
 * An interface for traversing graphs (as a subclass of the {@link graph.Graph} interface) is provided in
 * {@link graph.Traversal}.  Since this is a subclass of {@link graph.Graph}, a {@link graph.Traversal} object
 * will also be a {@link graph.Graph} object.  I.e., a {@link graph.Traversal} object does <i>not</i> need to
 * be provided with a graph to traverse, the traversal object is <i>itself</i> the graph that must be traversed.
 *
 * A breadth first implementation of {@link graph.Traversal} is provided in {@link graph.BreadthFirstTraversal}.
 *
 * An interface for topological sorts of acyclic graphs (as a subclass of the {@link graph.Graph} interface)
 * is provided in {@link graph.TopologicalSort}.  Since this is a subclass of {@link graph.Graph}, a
 * {@link graph.TopologicalSort} object will also be a {@link graph.Graph} object.  I.e., a
 * {@link graph.TopologicalSort} object does <i>not</i> need to be provided with a graph to sort, the sort object is
 * <i>itself</i> the graph that must be sorted.
 *
 * Only a "stub" implementation of {@link graph.TopologicalSort} is provided, in {@link graph.ReferenceCountSort}.
 * You should implement a reference counting topological sort in this class.
 *
 * @author Hugh Osborne.
 * @version November 2020.
 */
package graph;