package overloading;

import java.util.Random;
import java.util.Scanner;
 
/* java-tip : use util.Random class object to generate a random integer betn 0,N
 * 			: use Math.Random class to generate a random double in (0,1).
 */
public class sampleio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		//Random ro = new Random(1);
		int cnt,no=0,sum=0;
		while(scan.hasNext()){
			cnt = 0;
			int j=scan.nextInt();
			for(int i=0;i<j;i++){
				no=0;
				sum=0;
				for(int k=0;k<3;k++){
					no = scan.nextInt();
					sum+=no;
				}
				if(sum>=2)
					cnt++;
			}
			System.out.println(cnt);
		}
	}

}
