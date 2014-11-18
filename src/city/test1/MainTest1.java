package city.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * @author chris Main class for testing purposes.
 */
public class MainTest1 {
	public static void main(String[] args) {
		Station s1 = new Station("Tram");
		Station s2 = new Station("Bus");
		Station s3 = new Station("Metro");
		Station s4 = new Station("Tram");
		Station s5 = new Station("Tram");
		Station s6 = new Station("Trolley");
		Station s7 = new Station("Bus");
		Station s8 = new Station("Metro");

		HashSet<Station> hash1 = new HashSet<Station>();
		HashSet<Station> hash2 = new HashSet<Station>();
		HashSet<Station> hash3 = new HashSet<Station>();
		HashSet<Station> hash4 = new HashSet<Station>();
		HashSet<Station> hash5 = new HashSet<Station>();
		HashSet<Station> hash6 = new HashSet<Station>();

		hash4.add(s5);
		hash1.add(s1);
		hash2.add(s2);
		hash2.add(s3);
		hash3.add(s4);
		hash5.add(s6);
		hash5.add(s7);
		hash6.add(s8);

		Intersection i1 = new Intersection("Vladimirescu", hash1);
		Intersection i2 = new Intersection("Str. 1 Dec.", hash2);
		Intersection i3 = new Intersection("Posta Mare", hash3);
		Intersection i4 = new Intersection("Vulcan", hash3);
		Intersection i5 = new Intersection("Str. Grozavesti", hash4);
		Intersection i6 = new Intersection("Regie", hash4);

		// Intersection i1 = new Intersection("Int 1", hash1);
		// Intersection i2 = new Intersection("Int 2", hash2);
		// Intersection i3 = new Intersection("Int 3", hash3);
		// Intersection i4 = new Intersection("Int 4", hash3);
		// Intersection i5 = new Intersection("Int 5", hash4);
		// Intersection i6 = new Intersection("Int 6", hash4);

		List<Intersection> vertices = new ArrayList<Intersection>();
		vertices.add(i1);
		vertices.add(i2);
		vertices.add(i3);
		vertices.add(i4);
		vertices.add(i5);
		vertices.add(i6);

		HashSet<DirectRoute<Intersection>> edges = new HashSet<DirectRoute<Intersection>>();

		edges.add(new DirectRoute<Intersection>("Linia 1", i1, i2, 12, 7));
		edges.add(new DirectRoute<Intersection>("Linia 2", i1, i3, 12, 9));
		edges.add(new DirectRoute<Intersection>("Linia 3", i1, i6, 12, 14));
		edges.add(new DirectRoute<Intersection>("Linia 1", i2, i3, 16, 10));
		edges.add(new DirectRoute<Intersection>("Linia 1", i2, i4, 16, 15));
		edges.add(new DirectRoute<Intersection>("Linia 4", i3, i6, 5, 2));
		edges.add(new DirectRoute<Intersection>("Linia 5", i3, i4, 5, 11));
		edges.add(new DirectRoute<Intersection>("Linia 5", i4, i5, 7, 6));
		edges.add(new DirectRoute<Intersection>("Linia 4", i5, i6, 8, 9));

		AdjGraph<Intersection, DirectRoute<Intersection>> graph = new AdjGraph<>(
				vertices, edges);

		ISearchAlgoWithCost<Intersection, DirectRoute<Intersection>> search = new DFSAllPaths<>();

		List<List<Intersection>> allRoutesResult = search.searchAllPaths(i1,
				i5, graph);

		Adder<Intersection, DirectRoute<Intersection>> adder = new SpeedAdder<Intersection, DirectRoute<Intersection>>();
		Comparator<Intersection, DirectRoute<Intersection>> comp = new SpeedComparator<Intersection, DirectRoute<Intersection>>();
		List<DirectRoute<Intersection>> shortestRouteResult = search
				.getCheapestRoute(i1, i5, graph, comp, adder);

		OutputDevice<Intersection, DirectRoute<Intersection>> printer = new OutputDevice<>();

		// Prints all paths from i1 to i5
		printer.printAllPaths(allRoutesResult);

		// Prints shortest path from i1 to i5
		printer.printShortestPath(i1, shortestRouteResult);

	}
}
