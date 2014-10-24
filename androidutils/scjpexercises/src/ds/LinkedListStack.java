package ds;

class node{
	String val;
	node next;
	
	node(String val){
		this.val=val;
		this.next=null;
	}
}

public class LinkedListStack {

	/**
	 * @param args
	 */
	node first;
	
	public LinkedListStack() {
		// TODO Auto-generated constructor stub
		first = null;
	}
	
	public void push(String a){
		node oldfirst=first;
	//	System.out.println("adding +"+a);
		node n = new node(a);
		n.next=oldfirst;
		first=n;
	}
	
	public boolean isempty(){
		return first==null;
	}
	
	public String pop(){
		String k = first.val;
		node oldfirst=first;
		first=first.next;
		oldfirst.next=null;
		return k;
	}
	
	public void popandprintstack(){
		while(!isempty()){
			System.out.println(pop());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack lls = new LinkedListStack();
		for(int i=10;i>0;i--){
			lls.push(""+i);
		}
		lls.popandprintstack();
	}

	 
}
