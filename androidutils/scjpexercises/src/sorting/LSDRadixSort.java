package sorting;

import java.util.Scanner;
//incomplete refer String sorts
public class LSDRadixSort {

	static int BITS_PER_BYTE = 8;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter no. of digits yuo want to sort");
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("dig = "+digit(257,256,2));
		radixSort(arr);
	}

	//B is byte no indexed from 0 starting from left
	private static int digit(int key, int R, int B){
		
		return (key>>8*(4-B-1))&(R-1);
		
	}
	
	 // LSD sort an array of integers, treating each int as 4 bytes
    // assumes integers are nonnegative
	private static void radixSort(int[] arr) {
		// TODO Auto-generated method stub
		int BITS = 32; //no. of bits in integer
		int W = BITS/BITS_PER_BYTE;
		int R = 1<<BITS_PER_BYTE;
		int MASK = R-1;//digit wise mask : 0xff
		
		System.out.println(" w = "+W+" R = "+R+" mask = "+MASK);
		
		int N = arr.length;
		int aux[] = new int[N];//notice extra space complexity for radix sort
		
		for(int d=0;d<W;d++){//iterate for every byte
			//compute frequency counts
			// compute frequency counts
			System.out.println("---");
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {           
                int c = (arr[i] >> BITS_PER_BYTE*d) & MASK;
                System.out.println(" c = "+c);
                count[c + 1]++;
            }
			//compute cumulates
			
			//
		}
		
		
	}

}
