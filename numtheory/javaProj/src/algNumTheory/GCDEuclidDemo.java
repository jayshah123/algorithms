package algNumTheory;

public class GCDEuclidDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcdEuclid(36, 100));
		for(int i : gcdExtendedEuclid(99, 78)){
			System.out.println(i);
		}
		for(int i : gcdExtendedEuclid(899, 493)){
			System.out.println(i);
		}
	}
	
	/**
	 * pg 858 cormen
	 * @param a
	 * @param b
	 * @return
	 */
	private static int gcdEuclid(int a,int b){
		System.out.println("a = "+a+" b = "+b);
		if(b==0){
			return a;
		} else {
			return gcdEuclid(b, a%b);
		}
	}
	
	/**
	 * pg 860 cormen
	 * returns a three element array (g,x,y) where g = ax+by
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] gcdExtendedEuclid(int a , int b){
		if(b==0){
			int[] ret = new int[3];
			ret[0] = a; ret[1] = 1; ret[2] = 0;
			return ret;
		}
		int[] dasharr = gcdExtendedEuclid(b, a%b);
		int d_ = dasharr[0],x_ = dasharr[1],y_=dasharr[2];
		int[] finret = new int[3];
		finret[0] = d_;
		finret[1] = y_;
		finret[2] = x_ - (a/b)*y_;
		return finret;
	}

}
