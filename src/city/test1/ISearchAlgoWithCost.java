package city.test1;

import java.util.List;

/**
 * Interface used in searching algorithms for finding the cheapest path based on
 * some arbitrary attribute.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public interface ISearchAlgoWithCost<T, E extends IEdge<T>> extends
		ISearchAlgorithm<T, E> {
	/**
	 * Gets the shortest path between two
	 * 
	 * @param start
	 *            The first element of the path
	 * @param end
	 *            The end of the path.
	 * @param graph
	 *            Graph of T vertices and E edges.
	 * @param comparator
	 *            Compares weights.
	 * @param adder
	 *            Adds the values of edge weights into an internal structure for
	 *            measuring 'distance'.
	 * @return A list containing all the edges through which the shortest path
	 *         goes
	 */
	public List<E> getCheapestRoute(T start, T end,
			IAdjacencyListGraph<T, E> graph, Comparator<T, E> comparator,
			Adder<T, E> adder);
}
