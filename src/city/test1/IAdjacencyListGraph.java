package city.test1;

import java.util.Map;
import java.util.Set;

/**
 * Generic interface for a graph represented through adjacency lists
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 * 
 */
public interface IAdjacencyListGraph<T, E extends IEdge<T>> extends
		IGraph<T, E> {
	Set<E> getAdjacencyList(T node);

	Map<T, Set<E>> getAllAdjacencyLists();
}