package overloading;

public class Easyoverloading {

	/*
	 *  In every case when an exact match is not found,
	 *  the JVM uses the method with the smallest argument that is wider 
	 *  than the parameter.
	 *  Also the compiler will choose widening over boxing.
	 *  Also the compiler will choose widening over var-args.
	 *  Also the compiler will choose boxing over var-args.
	 */
	
	static void go(Integer x){
		System.out.println("integer ");
	}
	
	static void go(long l){
		System.out.println("long");
	}
	
	static void go(double f){
		System.out.println("double");
	}
	
	static void go(byte... b){ //notice the var args accepting function
		System.out.println("haha var-args");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i=5;
		byte b=5;
		short s = 5;
		int k = 5;
		float f = 5;
		long l =5;
		go(b);
		go(s);
		go(k);
		go(f);
		go(l);
		go(i);
		go(b,b);
	}

}
