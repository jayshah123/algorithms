package ds;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		int j = 0;
		int max = 0;
		while (scanner.hasNext()) {
			i = scanner.nextInt();
			j = scanner.nextInt();

			max = 0;

			if (i < j) {
				for (int it = i; it <= j; it++) {
					int cyclecount = getCycleCount(it);
					if (max < cyclecount) {
						max = cyclecount;
					}
				}
			} else{
				for (int it = j; it <= i; it++) {
					int cyclecount = getCycleCount(it);
					if (max < cyclecount) {
						max = cyclecount;
					}
				}
			}
			System.out.println(i + " " + j + " " + max);
		}

	}

	static int getCycleCount(int n) {
		int cnt = 0;
		if (n == 1)
			return 1;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
				cnt++;
			} else {
				n = 3 * n + 1;
				cnt++;
			}
		}
		return cnt + 1;
	}

}
