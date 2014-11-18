package city.test1;

/**
 * Generic interface for adding weights in a graph 'shortest paths' algorithm
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public interface Adder<T, E extends IEdge<T>> {
	double addCost(E edge, double value);
}
