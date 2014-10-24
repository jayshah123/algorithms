package sorting;

import java.util.HashMap;
import java.util.Scanner;

public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inp,outp;
		final int RANGE = 10000;
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		inp = new int[n];
		outp = new int[n];
		int[] count = new int[RANGE];//takes up this much space problem!!
		
		//build histogram
		for(int i=0;i<n;i++){
			inp[i]=in.nextInt();
			++count[inp[i]];
		}
		
		//prefix sum
		for (int i = 1; i <= RANGE-1; ++i)
	        count[i] += count[i-1];
		
		/*for(int i = 0 ; i < 100 ; i++)
			System.out.print(" "+count[i]);*/
		
		//copy to output
		for(int i=0;i<n;i++){
			outp[--count[inp[i]]]=inp[i];
		}
		
		for(int i = 0 ; i < n ; i++)
			System.out.print("\n "+outp[i]);
		
		
		
		
	}

}
