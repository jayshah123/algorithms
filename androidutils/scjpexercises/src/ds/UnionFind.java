package ds;

public class UnionFind {

	/**
	 * @param args
	 * 
	 *
	 */
	
	static int[][] graph;
	
	public static void main(String[] args) {
		
		graph = new int[5][5];
		graph[0][1]=1;
		graph[1][0]=1;
		
		graph[0][4]=1;
		graph[4][0]=1;
		
		graph[4][3]=1;
		graph[3][4]=1;
		
		
		
	}

}
