package city.test1;

import java.util.Set;

/**
 * Generic interface for a graph.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public interface IGraph<T, E extends IEdge<T>> {
	/**
	 * 
	 * @return A set of with the graph's vertices
	 */
	public Set<T> getVertices();

	/**
	 * 
	 * @return A set with the graph's edges.
	 */
	public Set<E> getEdges();
}
