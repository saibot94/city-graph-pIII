package city.test1;

/**
 * @author chris Class used for comparing two weights: a double value and the
 *         value of an edge's speed.
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public class SpeedComparator<T, E extends IEdgeWithSpeed<T>> implements
		Comparator<T, E> {

	@Override
	public int compare(E edge1, double currentCost, double newCost) {
		if (newCost == Comparator.INF) {
			return 1;
		} else if (newCost < edge1.getSpeed() + currentCost) {
			return -1;
		} else {
			return 1;
		}

	}

}
