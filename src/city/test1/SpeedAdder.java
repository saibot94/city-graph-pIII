package city.test1;

/**
 * 
 * @author chris Class that adds edge weights based on the speed attribute.
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public class SpeedAdder<T, E extends IEdgeWithSpeed<T>> implements Adder<T, E> {

	@Override
	public double addCost(E edge, double value) {
		return edge.getSpeed() + value;
	}

}
