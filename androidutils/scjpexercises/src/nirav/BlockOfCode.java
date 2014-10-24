package nirav;

import java.util.LinkedList;

public class BlockOfCode {//this is a node in the graph

	int head;
	LinkedList<String> li ;
	BlockOfCode b1,b2;
	int nextHead1,nextHead2;

	public BlockOfCode(int h) {
		li = new LinkedList<String>();
		// TODO Auto-generated constructor stub
		head = h;
	}
	
	public void appendline(String s){
		li.add(s);
	}
	
	public void setNextHead1(int nextHead1) {
		this.nextHead1 = nextHead1;
	}
	
	public void setNextHead2(int nextHead2) {
		this.nextHead2 = nextHead2;
	}
	
	public void setNextBlock(BlockOfCode block1,BlockOfCode block2){
		b1=block1;
		b2=block2;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			String s = "";
			s+=" head : "+head+"\n";
			for( String j : li){
				s=s+" "+j;
			}
			s = s+" \n\t nexthead1 - "+nextHead1+" nextHead2 - "+nextHead2;
		return s;
		}
	
}
