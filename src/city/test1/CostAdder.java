package city.test1;

/**
 * Adds the cost of two edges for the shortest path algorithm.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public class CostAdder<T, E extends IEdgeWithCost<T>> implements Adder<T, E> {

	@Override
	public double addCost(E edge, double value) {
		return edge.getCost() + value;
	}

}
