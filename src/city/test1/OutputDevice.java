package city.test1;

import java.util.Collections;
import java.util.List;

/**
 * @author chris Outputs the results of the graph search algorithms
 * 
 * @param <T>
 *            Vertex
 * @param <E>
 *            Edge
 */
public class OutputDevice<T, E extends IEdge<T>> {

	/**
	 * Prints the shortest path.
	 * 
	 * @param start
	 *            The starting point of the path
	 * @param path
	 *            A list of edges from the shortest path
	 */
	public void printShortestPath(T start, List<E> path) {
		System.out.println("Shortest path in the graph:  ");
		if (path.size() == 0) {
			System.out.println("No connection!");
		}
		Collections.reverse(path);
		System.out.println("Start from ");
		System.out.println(start);
		T currentVertex = start;

		if (path.size() > 1) {
			for (int i = 1; i < path.size(); i++) {
				for (T vertex : path.get(i).getEnds()) {
					if (vertex != currentVertex) {
						currentVertex = vertex;
						break;
					}
				}
				System.out.println("- to... \n");
				System.out.print(currentVertex);
				System.out.println("- on route...");
				System.out.println("\t" + path.get(i) + "\n");
				if (i < path.size() - 1) {
					System.out.println("- then from...");
					System.out.println(currentVertex);
				} else {
					System.out.println("- then from...");
					System.out.println(currentVertex);
					System.out.println("- to...\n");
					for (T vertex : path.get(i).getEnds()) {
						if (vertex != currentVertex) {
							currentVertex = vertex;
							break;
						}
					}
					System.out.println(currentVertex);
				}
			}
		} else {
			System.out.println("to... ");
			E edge = path.get(0);
			for (T v : edge.getEnds()) {
				if (v != start) {
					System.out.println(v);
				}
			}
			System.out.println("on edge");
			System.out.println(edge);
		}
	}

	/**
	 * Prints all the paths possible in a graph
	 * 
	 * @param paths
	 *            A list of all the paths
	 * 
	 */
	public void printAllPaths(List<List<T>> paths) {
		System.out.println("All the possible paths are: \n");
		for (List<T> l : paths) {
			System.out.println("----- Start of path ----- ");
			System.out.println("From: ");
			System.out.print(l.get(0));
			for (int i = 1; i < l.size(); i++) {
				if (i != l.size() - 1) {
					System.out.println("to... ");
					System.out.println(l.get(i));
				} else {
					System.out.println("Arriving at: ");
					System.out.print(l.get(i));
				}
			}

			System.out.println("----- End of path -----\n ");
		}
	}
}
