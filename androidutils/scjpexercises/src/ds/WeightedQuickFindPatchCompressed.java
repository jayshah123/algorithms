package ds;

public class WeightedQuickFindPatchCompressed {

	
	private int[] ids;
	private int[] sz;
	
	public WeightedQuickFindPatchCompressed(int N) {
		// Initially all set roots are disjoint and self roots
		ids = new int[N];
		sz = new int[N];
		for(int i = 0 ; i< N; i++){
			ids[i]=i;
			sz[i]=1;
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s="";
		for(int i=0;i<ids.length;i++){
			s+="i = "+i+" root = "+root(i)+"\n";
		}
		return s;//super.toString();
	}
	
	/*
	 * return true if p,q belong to same set
	 */
	public boolean find(int p,int q){
		return root(p)==root(q);
	}
	
	/*
	 * make union of sets represented by p and q
	 */
	public void union(int i,int j){
		int p = root(i);
		int q = root(j);
		//weighted union : merge smaller tree into larger one
		if(sz[p]<sz[q]){
			ids[p]=ids[q];
			sz[q]+=sz[p];
		}else{
			ids[q]=ids[p];
			sz[p]+=sz[q];
		}
	}
	
	private int root(int i){
		while(i!=ids[i]){
			//path compression : make child point to grandparent  
			ids[i]=ids[ids[i]];
			i=ids[i];
		}
		return i;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		WeightedQuickFindPatchCompressed wqfpc = new WeightedQuickFindPatchCompressed(10);
		wqfpc.union(3, 4);
		wqfpc.union(4, 9);
		wqfpc.union(8, 0);
		wqfpc.union(2, 3);
		wqfpc.union(6, 5);
		wqfpc.union(5, 9);
		wqfpc.union(7, 3);
		wqfpc.union(8, 4);
		wqfpc.union(1, 6);
		
		System.out.println(" 2 8 = "+wqfpc.find(2, 8));
		System.out.println(" 1 3 = "+wqfpc.find(1, 3));
		System.out.println(" 7 9 = "+wqfpc.find(7, 9));
		System.out.println(" 4 0 = "+wqfpc.find(4, 0));
		
		System.out.println(wqfpc);
		
	}

}
