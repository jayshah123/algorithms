package geometry;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;



public class GrahamScan {

	public static void main(String args[]) throws IOException{
		
		int N;
		ArrayList<Point> pointArray = new ArrayList<Point>();
		Reader.init(System.in);
		N = Reader.nextInt();
		Random ran = new Random();
		for(int i =0;i<N;i++){
			pointArray.add(new Point(ran.nextInt(1000), ran.nextInt(1000)));
		    System.out.println(" point no "+i+" = "+pointArray.get(i));
		}
		System.out.println();
		
		PriorityQueue<Point> pointBag = new PriorityQueue<Point>(N, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.y-o2.y;
			}
		});
		pointBag.addAll(pointArray);
		for(int i =0;i<N;i++){
		   System.out.println(" point no "+i+" = "+pointBag.poll());
		}
		
	}
	
}

class Reader {

	static BufferedReader reader;
	    static StringTokenizer tokenizer;

	    /** call this method to initialize reader for InputStream */
	    static void init(InputStream input) {
	        reader = new BufferedReader(
	                     new InputStreamReader(input) );
	        tokenizer = new StringTokenizer("");
	    }

	    /** get next word */
	    static String next() throws IOException {
	        while ( ! tokenizer.hasMoreTokens() ) {
	            //TODO add check for eof if necessary
	            tokenizer = new StringTokenizer(
	                   reader.readLine() );
	        }
	        return tokenizer.nextToken();
	    }

	    static int nextInt() throws IOException {
	        return Integer.parseInt( next() );
	    }
		
	    static double nextDouble() throws IOException {
	        return Double.parseDouble( next() );
	    }
	
	
}