package codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	
	static int[] arr;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		Scanner sc;
		ArrayList<Integer> list= new ArrayList<Integer>();
		ArrayList<Integer> list2= new ArrayList<Integer>();
		
		sc = new Scanner(System.in);
		N = sc.nextInt();
		arr=new int[N];
		for(int i=0;i<N;i++){
			arr[i]=sc.nextInt();
			
		}
		Arrays.sort(arr);
		
		int mx = arr[N-1];
		int j;
		for( j=arr.length;j-2>0&&arr[j-2]==mx;j--);
		
		
		for(int i=0;i<j;){
			//System.out.print(arr[i]+" ");
			if(!list.contains(arr[i]))
				list.add(arr[i]);
			i=i+2;	
		}
	//	System.out.print(mx+" ");
		
		for(int i=j-2;i>0;){
			//System.out.print(arr[i]+" ");
			if(!list2.contains(arr[i]))
				list2.add(arr[i]);
			i=i-2;
		}
		if(list.contains(mx))
			System.out.println(list.size()+list2.size());
		else
			System.out.println(list.size()+list2.size()+1);
		//System.out.println();
		for(Integer i : list){
			System.out.print(i+" ");
		}
		if(!list.contains(mx))
		System.out.print(mx+" ");
		for(Integer i : list2){
			System.out.print(i+" ");
		}
		

	}

}
