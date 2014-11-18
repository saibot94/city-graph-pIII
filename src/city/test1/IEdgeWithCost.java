package city.test1;

/**
 * Interface of an edge that has a cost attribute.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 */
public interface IEdgeWithCost<T> extends IEdge<T> {
	double getCost();
}
