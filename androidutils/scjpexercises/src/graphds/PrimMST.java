package graphds;

import java.nio.channels.SelectableChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST {

	EdgeWeightedGraph gr;

	public PrimMST() {
		// TODO Auto-generated constructor stub
		gr = new EdgeWeightedGraph(System.in);
		System.out.println(gr);
		Iterable<Edge> li = gr.getAdjacent(1);

	}

	void process() {
		int selectedVertex = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		assert (gr != null);
		Set<Integer> s = new HashSet<Integer>();
		s.add(selectedVertex);
		while (s.size() != gr.V()) {
			// for each adjacent edge to currently selected vertex add it in
			// pqueue
			addAllAdjacentedgestoqu(pq, selectedVertex,s);
			Edge selectedEdge = pq.poll();
			
			while(s.contains(selectedEdge.either())&&s.contains(selectedEdge.other(selectedEdge.either()))){
				selectedEdge = pq.poll();
			}
			System.out.println("selected edge " + selectedEdge);
			 selectedVertex = selectedEdge.either();
			if (s.contains(selectedVertex)) {	
				selectedVertex = selectedEdge.other(selectedVertex);
			}
			System.out.println("adding vertex - "+selectedVertex);
			s.add(selectedVertex);
		}

	}

	void addAllAdjacentedgestoqu(PriorityQueue<Edge> pq, int vertex,Set<Integer> s) {
		Iterable<Edge> li = gr.getAdjacent(vertex);
		Iterator<Edge> it = li.iterator();
		while (it.hasNext()) {
			Edge e = it.next();
			if(s.contains(e.other(vertex)))
				continue;
			pq.add(e);
		}
	}

}
