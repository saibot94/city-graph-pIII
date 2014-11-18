package city.test1;

/**
 * An edge of a graph that has the speed attribute.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 */
public interface IEdgeWithSpeed<T> extends IEdge<T> {
	public double getSpeed();
}
