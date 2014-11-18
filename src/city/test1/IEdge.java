package city.test1;

import java.util.Set;

/**
 * Generic interface of an edge from a graph
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 */
public interface IEdge<T> {
	public Set<T> getEnds();
}
