package graphds;

//An instance of this class represents a simple edge in a graph
public class Edge implements Comparable<Edge> {

	private final int v, w; // vertices
	private final double weight; // weight of the edge

	public Edge(int v, int w, double weight) {
		// TODO Auto-generated constructor stub
		if (v < 0 || w < 0) {
			throw new IllegalArgumentException("no negative vertex please");
		}
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * Returns a string representation of the edge.
	 * 
	 * @return a string representation of the edge
	 */
	public String toString() {
		return String.format("%d-%d %.5f", v, w, weight);
	}

	public double getWeight() {
		return weight;
	}

	public int either() {
		return v;
	}

	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new IllegalArgumentException("illegal vertex for other");
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Edge e = (Edge) obj;
		if ((this.v == e.v && this.w == e.w || this.w == e.v && this.v == e.w)&&this.weight==e.weight)
			return true;
		return false;
	}

	@Override
	public int compareTo(Edge that) {
		// TODO Auto-generated method stub
		if (this.weight == that.weight)
			return 0;
		return this.weight > that.weight ? 1 : -1;
	}

}
