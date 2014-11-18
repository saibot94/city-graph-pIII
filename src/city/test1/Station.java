package city.test1;

/**
 * @author chris Class representing one of the many possible stations found in
 *         an intersection.
 */
public class Station {

	private String name;

	public Station(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Returns the station name.
	 */
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
