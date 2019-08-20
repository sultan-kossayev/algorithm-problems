import java.util.*;

/**
* https://www.hackerrank.com/challenges/2d-array/problem
*/
public class HourGlassArray {
	
	public static void main(String... args) {
		int[][] arr = getArr();

		int res = Integer.MIN_VALUE;
		for (int i = 0; i < 4;i++) {
			for (int j = 0; j < 4;j++) {
				int l1 = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
				int l2 = arr[i + 1][j + 1];
				int l3 = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i +2][j + 2];

				int sum = l1 + l2 + l3;

				res = Math.max(res, sum);
			}
		}

		System.out.println(res);
	}

	private static int[][] getArr() {
		Scanner scanner = new Scanner(System.in);
		int n = 6;
		int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        return arr;
	}

}