package city.test1;

/**
 * @author chris Interface for a graph in which edges can be added or removed,
 *         as well as vertices.
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public interface IWritableGraph<T, E extends IEdge<T>> extends IGraph<T, E> {
	public void addVertex(T vertex);

	public void addEdge(E edge);

	public T removeVertex(T vertex);

	public E removeEdge(E edge);

	boolean existsVertex(T vertex);
}
