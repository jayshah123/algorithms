

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	static int lb;
	static int ub;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N, sum = 0, ser=0,other=0;
		int[] arr;
		lb = 0;
		Scanner scna = new Scanner(System.in);
		N = scna.nextInt();
		ub = N - 1;
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scna.nextInt();
			sum += arr[i];
		}
		while(lb<ub){
			ser+=maxinrange(lb,ub,arr);
			other+=maxinrange(lb, ub, arr);
		}
		if(ser+other<sum)
			ser+=arr[lb];
		System.out.println(ser+" "+other);
		
	}

	public static int maxinrange(int l, int u, int[] arr) {
		if (arr[l] > arr[u]) {
			lb++;
			return arr[l];

		} else {
			ub--;
			return arr[u];
		}
	}

}
