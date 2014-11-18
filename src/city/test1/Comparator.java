package city.test1;

/**
 * Generic interface for comparing edges in a graph.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public interface Comparator<T, E extends IEdge<T>> {
	/**
	 * Value used for Infinite in Dijkstra's algorithm
	 */
	public final double INF = -1.0;

	public int compare(E edge1, double currentCost, double newCost);
}
