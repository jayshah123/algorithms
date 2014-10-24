package ds;

import java.io.IOException;

public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		QuickReader q = new QuickReader();
		q.init(System.in);
		
		int N = q.nextInt();
		System.out.println(N);
		//while(q.tokenizer.hasMoreTokens()){
			System.out.println(q.next());
			System.out.println(q.nextInt());
			System.out.println(q.next());
			System.out.println(q.nextInt());
		//}
			
			Bag<Integer> bg = new Bag<Integer>();
			bg.add(new Integer(3));
			bg.add(new Integer(2));
			for (Integer i : bg){
				System.out.println(" item = "+i);
			}
		
	}

}
