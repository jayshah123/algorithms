package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main6 {
	static ArrayList<Integer> typearr = new ArrayList<Integer>();
	static ArrayList<Integer> htarr = new ArrayList<Integer>();
	static ArrayList<Integer> massarr = new ArrayList<Integer>();
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		int jumpHeight;
		int candycnt = 0;
		
		
		QuickReader.init(System.in);
		int N = QuickReader.nextInt();
		jumpHeight = QuickReader.nextInt();
		for(int i=0;i<N;i++){
			typearr.add(QuickReader.nextInt());
			htarr.add(QuickReader.nextInt());
			massarr.add(QuickReader.nextInt());
		}
		
		int indexChoiceFirst=0,removalIndex;
		if(massarr.get(getIndexforItem(1, jumpHeight))>massarr.get(getIndexforItem(1, jumpHeight))){
			indexChoiceFirst = 1;
		}
		for(int i=0;i<N;i++){
			int removalIndex1 = getIndexforItem(indexChoiceFirst, jumpHeight);
			if(removalIndex1 == -1)
				continue;
			else
				candycnt++;
			System.out.println("index removed = "+removalIndex1);
			indexChoiceFirst = indexChoiceFirst==1?0:1;
			jumpHeight += massarr.get(removalIndex1);
			htarr.remove(removalIndex1);
			massarr.remove(removalIndex1);
			typearr.remove(removalIndex1);
		}
		System.out.println("candy = "+candycnt);
	}
	
	public static int getIndexforItem(int type, int lessthanheight){
		
		int retIndex=-1;
		int massmax = -1;
		for(int j=0;j<htarr.size();j++){
			if(typearr.get(j)==type && htarr.get(j)<=lessthanheight){
				if(massarr.get(j)>massmax){
					retIndex = j;
					massmax = massarr.get(j);
				}
			}
		}
		return retIndex;
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