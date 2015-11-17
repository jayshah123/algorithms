package algCompGeometry;

public class PointUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] first = { 0, 0 };
		int[] second = { 1, 1 };
		int[] first3d = { 0, 0, 0 };
		int[] second3d = { 1, 1, 1 };
		System.out.println(pointDistanceN(first, second, 2));
		System.out.println(pointDistanceN(first3d, second3d, 3));
		System.out.println(pointDistanceN(first3d, second3d, 2));
	}

	// distance between two points of n dimensions
	static double pointDistanceN(int[] a, int[] b, int n) {
		
		if (a == null || b == null) {
			return 0;
		}
		
		int[] dis = new int[n];
		for (int i = 0; i < n; i++) {
			dis[i] = Math.abs(a[i] - b[i]);
		}
		
		int retDistance = 0;
		for (int i = 0; i < n; i++) {
			retDistance += dis[i] * dis[i];
		}
		return Math.sqrt(retDistance);
	
	}

}
