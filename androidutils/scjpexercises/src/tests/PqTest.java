package tests;

import graphds.Edge;
import ds.MaxPQ;

public class PqTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


         MaxPQ<Integer> pq = new MaxPQ<Integer>(10);
         pq.insert(4);
         pq.insert(1);
         pq.insert(10);
         pq.insert(35);
         pq.insert(-11);
         
         System.out.println(pq.delMax());
         System.out.println(pq.max());
         System.out.println(pq.delMax());
         System.out.println(pq.delMax());
         System.out.println(pq.delMax());
         System.out.println(pq.delMax());
         
         

         MaxPQ<String> pqs = new MaxPQ<String>(10);
         pqs.insert("Hell");
         pqs.insert("hello");
         pqs.insert("Hello");
         pqs.insert("Hi");
         pqs.insert("A");
         
         System.out.println(pqs.delMax());
         System.out.println(pqs.max());
         System.out.println(pqs.delMax());
         System.out.println(pqs.delMax());
         System.out.println(pqs.delMax());
         System.out.println(pqs.delMax());
         
         MaxPQ<Edge> pqe = new MaxPQ<Edge>(10);
         pqe.insert(new Edge(1,2,10));
         pqe.insert(new Edge(2,3,22));
         pqe.insert(new Edge(2,2,32));
         pqe.insert(new Edge(1,2,22));
         pqe.insert(new Edge(1,1,100));
         
         System.out.println(pqe.delMax());
         System.out.println(pqe.max());
         System.out.println(pqe.delMax());
         System.out.println(pqe.delMax());
         System.out.println(pqe.delMax());
         System.out.println(pqe.delMax());
	}

}
