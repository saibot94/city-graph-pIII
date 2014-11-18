package city.test1;

import java.util.Set;

/**
 * An intersection is, in fact, a vertex in the city map graph. It contains a
 * number of stations and has a name.
 * 
 * @author chris
 * 
 */
public class Intersection {
	private Set<Station> stations;
	private String name;

	public String getName() {
		return this.name;
	}

	public Intersection(String name, Set<Station> stations) {
		this.stations = stations;
		this.name = name;
	}

	/**
	 * 
	 * @return A set of the stations in the intersection
	 */
	public Set<Station> getStations() {
		return this.stations;
	}

	@Override
	public String toString() {
		String res = new String();
		res += "Intersection " + this.name + "\n";
		res += "\tStations: \n";
		for (Station s : this.stations) {
			res += "\t -" + s.toString() + "\n";
		}
		return res;
	}
}
