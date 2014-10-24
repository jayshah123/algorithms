package overloading;

abstract class superclass {
	int a;
	abstract void impme();
	void partimplemented(){
		System.out.println("super class part of implementation");
		System.out.println("rest of the responsibility on subclass that extend me");
	}
}

class subclass extends superclass{

	@Override
	void impme() {
		// TODO Auto-generated method stub
		System.out.println("concrete subclass is implementor of impme()");
	}
	
	@Override
	void partimplemented(){
		super.partimplemented();
		System.out.println("the implementation extension of superclass .. this is subclass");
	}
	
}

public class Overriding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		superclass s  = new subclass();
		s.impme();//runtime invocation of overridem method based on object type(not the reference type)
		System.out.println();
		s.partimplemented();
	}

}
