package uva;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BlocksWorld {

	
	static List<Integer>[] arr;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N, src, dst; // no of blocks in the world

		
		Scanner scanner = new Scanner(System.in);

		N = scanner.nextInt();
		arr = new ArrayList[N];
		while (scanner.hasNext()) {
			String s = scanner.nextLine();
			if (s.equals("quit")) {
				break;
			}

			StringTokenizer st = new StringTokenizer(s);
			while (st.hasMoreTokens()) {
				String first = st.nextToken();
				Integer second = Integer.parseInt(st.nextToken());
				src = second;
				String third = st.nextToken();
				Integer fourth = Integer.parseInt(st.nextToken());
				dst = fourth;

				if (src == dst)
					break;

				if (first.equals("move") && third.equals("onto")) {
					moveOntoCase(src, dst);
				} else if (first.equals("move") && third.equals("over")) {
					moveOverCase(src, dst);
				} else if (first.equals("pile") && third.equals("over")) {
					pileOverCase(src, dst);
				} else if (first.equals("pile") && third.equals("onto")) {
					pileOntoCase(src, dst);
				}
			}
		}
	}

	static void moveOntoCase(int src, int dst) {
		System.out.println("moveOnto Case");
		//find  the source stack
		//everything on top of A and B is removed
		List<Integer> li = arr[src];
		Iterator<Integer> it = li.iterator();
		while(it.hasNext()){
			Integer no = it.next();
			
			resetList(no);
		}
	}

	static void resetList(int no){
		List<Integer> list = arr[no];
		list.clear();
		list.add(no);
	}
	
	
	static void moveOverCase(int src, int dst) {
		System.out.println("move over case");
		//remove everything on top of src
	}

	static void pileOntoCase(int src, int dst) {
		System.out.println("pile onto case");
		//remove everything on top of dst
	}

	static void pileOverCase(int src, int dst) {
		System.out.println("pile over case");
		//nothing is removed, put src stack over dst stack
	}

}
