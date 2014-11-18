package city.test1;

/**
 * Interface for oriented edges.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex of a graph.
 */
public interface IOrientedEdge<T> extends IEdge<T> {
	/**
	 * 
	 * @return Starting vertex
	 */
	T getStart();

	/**
	 * 
	 * @return Ending vertex
	 */
	T getEnd();
}
