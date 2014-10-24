
public class Utility {
	
	public static int getMax(int[] arr){
		int mx = arr[0];
		for(int i : arr){
			if(i>mx){
				mx = i;
			}
		}
		return mx;
	}
	
}
