package sorting;

import java.util.Scanner;

public class MergeAndCountSort {

	static int arr[];

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int inversions = merge_and_count(0, arr.length - 1);
		System.out.println("no of inversions = " + inversions);
		printArr(arr);
	}

	// sort array passed and count inversions
	static int merge_and_count(int l, int u) {
		int rA = 0, rB = 0, rTotal = 0;
		if (l < u) {
			int mid = l + (u - l) / 2;
			rA = merge_and_count(l, mid);
			rB = merge_and_count(mid + 1, u);
			rTotal = merge(l, mid, u);
		}
		return rTotal + rA + rB;

	}

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	static int merge(int l, int mid, int u) {
		System.out.println("-- l = " + l + " mid = " + mid + " u = " + u
				+ " --");
		int helper[] = new int[u - l + 1];
		int cntA = l, cntB = mid + 1;
        int inversions=0;
		if(u==l){
			return 0;
		}
		
		if (u - l == 1) { // single case with two items , just swap items in positon
			if(arr[l]>arr[u]){
            	int item = arr[u];
            	arr[u]=arr[l];
            	arr[l]= item;
				System.out.println(" swappng l "+arr[l]+" and u = "+arr[u]);
				return 1;
            }
            
		} else {
			for (int i = 0; i < helper.length; i++) {

				//print cnts here for debug
				if ( (cntB <= u && arr[cntA] > arr[cntB]) || cntA > mid ) {
					helper[i] = arr[cntB];
					cntB++;
					inversions+=mid+1-cntA;
				} else {
					helper[i] = arr[cntA];
					cntA++;
				}
				//print cnts here for debug
			}
			for(int j = l;j<=u;j++){
				arr[j]=helper[j-l];
				//transfer back
			}
			return inversions;
		}

		
		
		return 0;

	}

}
