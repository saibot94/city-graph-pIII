package city.test1;

/**
 * @author chris Class used for comparing two weights: a double value and the
 *         value of an edge's cost.
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public class CostComparator<T, E extends IEdgeWithCost<T>> implements
		Comparator<T, E> {

	@Override
	public int compare(E edge1, double currentCost, double newCost) {
		if (newCost == Comparator.INF) {
			return 1;
		} else if (newCost < edge1.getCost() + currentCost) {
			return -1;
		} else {
			return 1;
		}

	}
}
