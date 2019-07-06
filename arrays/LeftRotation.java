/*
* https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
*/
import java.util.*;

public class LeftRotation {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String... args) {
		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);
		int d = Integer.parseInt(nd[1]);

		int[] a = getArr(n);

		// Time complexity: O(d * n);
		// there is an alternative solution but with space complexity O(n)
		for (int i = 0; i < d;i++) {
			int t = a[0];
			for (int j = 0; j < n - 1; j++) {
				a[j] = a[j + 1];
			}

			a[n - 1] = t;
		}

		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a, int s, int e, int d) {
		System.out.println(Arrays.toString(a) + "|| " + s + ", " + e);
		if (s >= e) {
			return;
		}

		for (int i = s, j = e, k = 0; k < d; k++, i++, j++) {
			int t = a[j];
			a[j] = a[i];
			a[i] = t;
		}

		swap(a, 0, e - d, d);
	}

	private static int[] getArr(int n) {
		String[] aItems = scanner.nextLine().split(" ");

		int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        return a;
	}
}