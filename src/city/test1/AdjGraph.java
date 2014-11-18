package city.test1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Adjacency graph used for representing the city map.
 * 
 * @author chris
 * 
 * @param <T>
 *            Intersection
 * @param <E>
 *            DirectRoute
 */
public class AdjGraph<T, E extends IEdge<T>> implements
		IAdjacencyListGraph<T, E> {

	private List<T> vertices;
	private List<E> edges;

	private Map<T, Set<E>> adjacencyList;

	public AdjGraph(List<T> vertices, Set<E> edges) {

		this.vertices = new LinkedList<>(vertices);
		this.edges = new LinkedList<E>(edges);

		/* Allocate memory for the adjacency list */
		this.adjacencyList = new HashMap<T, Set<E>>();
		for (int k = 0; k < vertices.size(); k++) {
			this.adjacencyList.put(vertices.get(k), new HashSet<E>());
		}

		generateAdjacencyList();

		System.out.println("Done generating adjacency list!");
	}

	private void generateAdjacencyList() {
		/* Iterate over all the edges, finding the links */
		for (int i = 0; i < vertices.size(); i++) {
			T tempIntersection = vertices.get(i);
			for (int j = 0; j < edges.size(); j++) {
				/* Get the current route */
				E currentRoute = edges.get(j);
				if (currentRoute.getEnds().contains(tempIntersection)) {
					for (T intersection : currentRoute.getEnds()) {
						/*
						 * Get the index of the intersections found on the route
						 * and add them to the adj. list
						 */
						this.adjacencyList.get(intersection).add(currentRoute);
					}
				}
			}
		}
	}

	@Override
	public Set<T> getVertices() {
		return new HashSet<>(this.vertices);
	}

	@Override
	public Set<E> getEdges() {
		return new HashSet<>(this.edges);
	}

	@Override
	public Map<T, Set<E>> getAllAdjacencyLists() {
		return this.adjacencyList;
	}

	@Override
	public Set<E> getAdjacencyList(T node) {
		return this.adjacencyList.get(node);
	}

}
