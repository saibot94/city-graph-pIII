package city.test1;

import java.util.HashSet;
import java.util.Set;

/**
 * Route between two intersections in a city map graph.
 * 
 * @author chris
 * 
 * @param <T>
 *            Vertex in the graph
 */
public class DirectRoute<T> implements IEdgeWithCost<T>, IEdgeWithSpeed<T> {

	private double cost;
	private double speed;
	private Set<T> stations;
	private String id;

	public DirectRoute(String id, T station1, T station2, double cost,
			double speed) {
		this.id = id;
		this.cost = cost;
		this.speed = speed;
		this.stations = new HashSet<T>();
		this.stations.add(station1);
		this.stations.add(station2);
	}

	public DirectRoute(T station1, T station2, double cost, double speed) {
		this.id = "anonima";
		this.cost = cost;
		this.speed = speed;
		this.stations = new HashSet<T>();
		this.stations.add(station1);
		this.stations.add(station2);
	}

	@Override
	public double getSpeed() {
		return this.speed;
	}

	@Override
	public double getCost() {
		return this.cost;
	}

	@Override
	public Set<T> getEnds() {

		return this.stations;
	}

	@Override
	public String toString() {
		return this.id + "\n";
	}

}
