package graphds;

import java.util.Iterator;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Edge e1 = new Edge(1, 2, 23.12);
		System.out.println(e1.getWeight());
		System.out.println(e1);
		
		
		
		Edge e2 = new Edge(2, 3, 55);
		System.out.println(e1.compareTo(e2));
		
		Edge e3 = new Edge(2, 3, 55);
		System.out.println(e2.equals(e1));
		
		
		PrimMST mst = new PrimMST();
		mst.process();
		/*EdgeWeightedGraph gr = new EdgeWeightedGraph(System.in);
		System.out.println(gr);
		Iterable<Edge> li = gr.getAdjacent(1);
		Iterator<Edge> it = li.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
	}

}
