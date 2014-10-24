package ds;

import java.util.*;


public class Mydate implements Comparable<Mydate>{

	
	int m,d,y;
	
	public Mydate(int m,int d,int y) {
		// TODO Auto-generated constructor stub
		this.m=m;
		this.y=y;
		this.d=d;
	}
	
	void printdate(){
		System.out.println(" "+m+" "+d+" "+y+" ");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//an array of Mydate
		Mydate[] mydatearr  = new Mydate[5];
		mydatearr[0]=new Mydate(0,0,0);
		mydatearr[1]=new Mydate(1,1,1);
		mydatearr[2]=new Mydate(2,2,2);
		mydatearr[3]=new Mydate(5,5,5);
		mydatearr[4]=new Mydate(3,3,3);
		Arrays.sort(mydatearr);// will use compareto() implemented by Mydate data type
		for(Mydate m : mydatearr){
			m.printdate();
		}
	}



	@Override
	public int compareTo(Mydate o) {
		// TODO Auto-generated method stub
		
		if(this.m>o.m && this.y>o.y && this.d> o.d)
			return -1;
		else
			return 1;
	}

}
