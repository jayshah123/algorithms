package graphds;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class EdgeWeightedGraph {

	private int V;
	private int E;
	private ArrayList<LinkedList<Edge>> adjList; 

	public EdgeWeightedGraph() {
		// TODO Auto-generated constructor stub
		V = 0;
		E = 0;
	}

	public EdgeWeightedGraph(InputStream in) {
		adjList = new ArrayList<LinkedList<Edge>>();
		Scanner s = new Scanner(in);
		V = s.nextInt();
		E = s.nextInt();

		for (int i = 0; i < V; i++) {
			adjList.add(new LinkedList<Edge>());
		}

		// add each edge
		for (int i = 0; i < E; i++) {
			int v = s.nextInt();
			int w = s.nextInt();
			double weight = s.nextDouble();
			Edge e = new Edge(v, w, weight);
			adjList.get(v).add(e);
			adjList.get(w).add(e);
		}

	}

	/*
	 * @return: return the no. of vertices in the graph
	 */
	int V() {
		return V;
	}

	/*
	 * @return: the no. of edges in the graph
	 */
	int E() {
		return E;
	}

	/*
	 * @param: add a weighted edge to the graph
	 */
	void addEdge(Edge e) {

		int v = e.either();
		int w = e.other(v);
		adjList.get(v).add(e);
		adjList.get(w).add(e);
		E++;
	}

	/*
	 * @param: the vertex for which you want incident edges
	 * 
	 * @return: a list of edges
	 */
	public Iterable<Edge> getAdjacent(int v) {
		return adjList.get(v);

	}

	/*
	 * @return: a list of all the edges in the graph
	 */
	public Iterable<Edge> getAllEdges() {
		return null;
		// TODO Auto-generated method stub
	
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "v = "+V+" e = "+E;
	}

}
