package exactstringmatching;

public class ZAlgorithm {

	int N;
	int[] Zval;
	int[] li,ri;
	String text;
	
	public ZAlgorithm(String txt) {
		// TODO Auto-generated constructor stub
		text = txt;
		N = txt.length();
		Zval = new int[N];
		li = new int[N];
		ri = new int[N];
	}
	
	void process(){
		for(int k=1;k<N;k++){
			int l = 0;
			int match=0;
			for(;k+l<text.length() && text.charAt(k+l)==text.charAt(l);match++,l++){
				
			}
			Zval[k]=match;
			if(match==1){
				li[k]=ri[k]=k;
			}
			if(match==0){
				li[k]=ri[k]=li[k-1];
			}
			//System.out.println("match = "+match);
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text="aabadaabcaaba";
		
		ZAlgorithm za = new ZAlgorithm(text);
		za.process();
		
	}

}
