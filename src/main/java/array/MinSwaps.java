import java.util.Scanner;

/**
* https://www.hackerrank.com/challenges/minimum-swaps-2/problem
*/
public class MinSwaps {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String... args) {
		int n = Integer.parseInt(scanner.nextLine());

		int[] arr = getArr(n);

		int count = 0;
		for (int i = 0; i < arr.length;i++) {

			if (i + 1 != arr[i]) {
				int idx = arr[i] - 1;

				int t = arr[i];
				arr[i] = arr[idx];
				arr[idx] = t;

				count++;
				i--;
			}
		}

		System.out.println(count);
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