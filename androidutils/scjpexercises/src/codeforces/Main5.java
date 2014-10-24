package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int teamcolor[][]= new int[10000][2];//0 home 1 away
        
		int colors[][] = new int[10000][2]; //homekit, awaykit 
		
		Reader.init(System.in);
		int n = Reader.nextInt();
		for(int i=0;i<n;i++){
			teamcolor[i][0]= Reader.nextInt();
			teamcolor[i][1]=Reader.nextInt();
		}
		
		//each team plays 1 match home, n-2 away
		for(int i=0;i<n;i++){
			System.out.println("i = "+i);
			//ith team
			for(int j=0;j<n;j++){//with other teamz
				if(i==j)
					continue;
				if(teamcolor[i][0]==teamcolor[j][1] || teamcolor[i][1]==teamcolor[j][0]){
					System.out.println("clash i j "+i+" "+j);
					colors[j][0]++;
					colors[i][0]++;
				}else{
					colors[i][1]++;//ith team plays with away
					colors[j][0]++;//jthe team plays at home
				}
			}
		}
		
		//print colors
		for(int i=0;i<n;i++){
			System.out.println("colors = "+colors[i][0]+"\t"+colors[i][1]);
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


