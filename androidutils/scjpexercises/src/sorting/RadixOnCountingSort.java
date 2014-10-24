package sorting;

import java.util.Scanner;

public class RadixOnCountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N;
		N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		printArr(arr);
		doRadixSort(arr);
		printArr(arr);
		
	}

	private static void doRadixSort(int[] arr) {
		// TODO Auto-generated method stub
		int max = getMax(arr);
		// for each digit
		for (int exp = 1; max / exp > 0; exp *= 10) {
			countSort(arr, exp);
		}
	}

	// does a sort of integers based on digit given by exp
	private static void countSort(int[] arr, int exp) {
		int[] output = new int[arr.length];//space complexity = n , better than full Range., can be bad in some cases
		int[] count = new int[10];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i] / exp % 10]++;
		}

		System.out.println("-count-");
		printArr(count);
		
		
		//prefix sum
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		System.out.println("-cumulative-");
		printArr(count);
		
		//put in output (see tricky indexing)
		for (int i = arr.length-1; i >=0; i--) {
			output[--count[arr[i] / exp % 10]] = arr[i];
		}
		System.out.println("---");
		printArr(output);
		 // Copy the output array to arr[], so that arr[] now
	    // contains sorted numbers according to curent digit
	    for (int i = 0; i < arr.length; i++)
	        arr[i] = output[i];

	}

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	public static int getMax(int[] arr) {
		int mx = arr[0];
		for (int i : arr) {
			if (i > mx) {
				mx = i;
			}
		}
		return mx;
	}

}
