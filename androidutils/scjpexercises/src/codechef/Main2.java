package codechef;

import java.io.IOException;

public class Main2 {

	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Reader r = new Reader();
		r.init(System.in);
		
		int N = r.nextInt();
	    long total=0;
		for(int i=0;i<N;i++){
	    	total+=r.nextInt();
	    }
		if(total==N*(N+1)/2)
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
