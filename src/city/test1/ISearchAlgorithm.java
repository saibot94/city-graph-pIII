package city.test1;

import java.util.List;

/**
 * Algorithm that is used for the searching of paths.
 * 
 * @author chris
 * 
 * @param <T>
 * @param <E>
 */
public interface ISearchAlgorithm<T, E extends IEdge<T>> {
	/**
	 * Searches for all the paths between start and end.
	 * 
	 * @param start
	 *            Start vertex.
	 * @param end
	 *            End vertex.
	 * @param graph
	 *            Graph.
	 * @return A list of lists of vertices, each list representing the ones
	 *         visited on a path.
	 */
	public List<List<T>> searchAllPaths(T start, T end,
			IAdjacencyListGraph<T, E> graph);

}
