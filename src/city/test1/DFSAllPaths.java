package city.test1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author chris Class used to get all the paths from one point to another in a
 *         graph, but also for finding the cheapest route between two vertices.
 * @param <T>
 *            Type defined for being used as an intersection on the road map.
 * @param <E>
 *            Road between intersections
 * 
 */
public class DFSAllPaths<T, E extends IEdge<T>> implements
		ISearchAlgoWithCost<T, E> {

	private Map<T, Boolean> marked;
	// private List<T> solution;
	private List<List<T>> paths;
	private List<T> currentPath;

	public DFSAllPaths() {
		paths = new LinkedList<List<T>>();
		currentPath = new LinkedList<T>();
	}

	@Override
	public List<List<T>> searchAllPaths(T start, T end,
			IAdjacencyListGraph<T, E> graph) {
		// this.solution = new ArrayList<T>();

		initValues(graph);
		searchPaths(start, end, graph);
		return paths;

	}

	private void searchPaths(T start, T end, IAdjacencyListGraph<T, E> graph) {

		currentPath.add(start);
		marked.put(start, true);

		if (start.equals(end)) {
			paths.add(new LinkedList<T>(currentPath));
		}

		else {
			Set<E> neighbors = graph.getAdjacencyList(start);

			for (E edge : neighbors) {
				T opposingVertex = getOpposingVertex(start, edge);
				if (!marked.get(opposingVertex)) {
					searchPaths(opposingVertex, end, graph);
				}
			}
		}

		// Remove the last element and make it "unvisited" */
		marked.put(start, false);
		currentPath.remove(currentPath.size() - 1);
	}

	// BFS Algorithm
	// private void searchPaths(T start, T end, IAdjacencyListGraph<T, E> graph)
	// {
	// Queue<T> q = new LinkedList<>();
	// q.add(start);
	// marked.put(start, true);
	// while (!q.isEmpty()) {
	// T temp = q.poll();
	// if (temp.equals(end)) {
	// break;
	// }
	// Set<E> neighbors = graph.getAdjacencyList(temp);
	//
	// for (E edge : neighbors) {
	// T opposingVertex = getOpposingVertex(temp, edge);
	// if (!marked.get(opposingVertex)) {
	// marked.put(opposingVertex, true); // mark the node
	// q.add(opposingVertex); // add it in the queue
	//
	// }
	// }
	//
	// }
	//
	// }

	private void initValues(IAdjacencyListGraph<T, E> graph) {
		/* Initialize the path list */
		paths = new LinkedList<List<T>>();
		currentPath = new LinkedList<T>();
		marked = new HashMap<T, Boolean>();
		for (T vertex : graph.getVertices()) {
			marked.put(vertex, false);
		}
	}

	private T getOpposingVertex(T temp, E edge) {
		T returnedVertex = null;
		for (T vertex : edge.getEnds()) {
			if (!temp.equals(vertex)) {
				returnedVertex = vertex;
			}
		}
		return returnedVertex;
	}

	@Override
	public List<E> getCheapestRoute(T start, T end,
			IAdjacencyListGraph<T, E> graph, Comparator<T, E> comparator,
			Adder<T, E> adder) {
		// Initializing the distance array - start node: 0, other nodes: +inf
		Map<T, Double> distanceTo = new HashMap<T, Double>();
		Map<T, E> edgeTo = new HashMap<T, E>();
		Queue<T> q = new LinkedList<T>();

		initValues(graph);

		for (T vertex : graph.getVertices()) {
			edgeTo.put(vertex, null);
			if (!vertex.equals(start)) {
				distanceTo.put(vertex, Comparator.INF);
			} else {
				marked.put(vertex, true);
				distanceTo.put(vertex, 0.0);
			}
		}

		// Perform Dijkstra's algorithm
		q.add(start);
		while (!q.isEmpty()) {
			T currentVertex = q.remove();
			marked.put(currentVertex, true);
			System.out.println(distanceTo.get(currentVertex));
			Set<E> neighbors = graph.getAdjacencyList(currentVertex);

			for (E edge : neighbors) {
				T opposingVertex = getOpposingVertex(currentVertex, edge);
				relax(currentVertex, edge, edgeTo, distanceTo, comparator,
						adder);
				if (!marked.get(opposingVertex)) {
					q.add(opposingVertex);
				}
			}

		}

		// Build solution based on the values that were computed

		return buildSolution(start, end, edgeTo);
	}

	private List<E> buildSolution(T start, T end, Map<T, E> edgeTo) {
		T currentVertex = end;
		List<E> path = new LinkedList<>();
		while (!currentVertex.equals(start)) {
			E edge = edgeTo.get(currentVertex);
			path.add(edge);
			currentVertex = getOpposingVertex(currentVertex, edge);
		}
		return path;
	}

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @param edgeTo
	 * @param distanceTo
	 * @param comp
	 * @param adder
	 */
	private void relax(T vertex, E edge, Map<T, E> edgeTo,
			Map<T, Double> distanceTo, Comparator<T, E> comp, Adder<T, E> adder) {
		T vertexOpposite = getOpposingVertex(vertex, edge);

		if (comp.compare(edge, distanceTo.get(vertex),
				distanceTo.get(vertexOpposite)) > 0) {
			distanceTo.put(vertexOpposite,
					adder.addCost(edge, distanceTo.get(vertex)));
			edgeTo.put(vertexOpposite, edge);
		}
	}

}