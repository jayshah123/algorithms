package algCompGeometry;

public class PointUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] first = { 0, 0 };
		double[] second = { 1, 1 };
		double[] first3d = { 0, 0, 0 };
		double[] second3d = { 1, 1, 1 };
		System.out.println(pointDistanceN(first, second, 2));
		System.out.println(pointDistanceN(first3d, second3d, 3));
		System.out.println(pointDistanceN(first3d, second3d, 2));
	}

	// distance between two points of n dimensions
	static double pointDistanceN(double[] a, double[] b, int n) {

		if (a == null || b == null) {
			return 0;
		}

		double[] dis = new double[n];
		for (int i = 0; i < n; i++) {
			dis[i] = Math.abs(a[i] - b[i]);
		}

		int retDistance = 0;
		for (int i = 0; i < n; i++) {
			retDistance += dis[i] * dis[i];
		}
		return Math.sqrt(retDistance);

	}

	// compute dot product AB.BC
	static double dotN(double[] A, double[] B, double[] C) {
		double[] AB = new double[A.length];
		double[] BC = new double[B.length];

		for (int i = 0; i < A.length; i++) {
			AB[i] = B[i] - A[i];
			BC[i] = C[i] - B[i];
		}

		// d.p. (A.B) = Sum over i=1 to n (AiBi)
		double ithDimProd = 0;
		for (int i = 0; i < A.length; i++) {
			ithDimProd += AB[i] * BC[i];
		}

		return ithDimProd;
	}

	// calculate cross product ABxAC
	// refer to determinant style formula for cross product
	static double cross2d(double[] A, double B[], double[] C) {
		double[] AB = new double[2];
		double[] AC = new double[2];
		AB[0] = B[0] - A[0];
		AB[1] = B[1] - A[1];
		AC[0] = C[0] - A[0];
		AC[1] = C[1] - A[1];
		double cross = AB[0] * AC[1] - AB[1] * AC[0];
		return cross;
	}
	
	/**
	 * Compute distance of line AB to point C
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	static double linePointDist(double[] A,double[] B,double[] C){
		return 0;
	}

	/**
	 * return area taken by a polygon described a list of points pts
	 * @param pts
	 * @return
	 */
	static double polygonArea2D(double[][] pts){
		double area=0;
		int N = pts.length;
		
		// triangulate the polygon one by one 
		// with p[0],p[i],p[i+1]
		
		return area;
		
	}

}
