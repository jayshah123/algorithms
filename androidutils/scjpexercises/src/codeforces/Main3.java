package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int data[][]=new int[1000][1000];
		int dp[][][] = new int[1000][1000][2];
		
		QuickReader.init(System.in);
		int N = QuickReader.nextInt();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				data[i][j]=QuickReader.nextInt();
			   System.out.println(findfactors(data[i][j], 2)+"\t"+findfactors(data[i][j], 5));
			}
		}
		
		
		//
		//for(int i=0;i<N;i++){
			//dp[0][i][i]=
		//}
		
		
	}
	
	public static int countzeros(int cnt){
	    return 0;
	}
	
	public static int findfactors(int no,int n){
		int cnt=0;
		while(no/n>0){
			if(no%n==0)
				cnt++;
			else
				break;
			no=no/n;
		}
		return cnt;
	}

}


 class QuickReader {
	

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

