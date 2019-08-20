import java.util.Scanner;
import java.util.Arrays;

public class ArrayManipulation {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String... args) {
		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int[][] queries = getQueries(m);

		long[] arr = new long[n];

		int idx1 = queries[0][0];
		int idx2 = queries[0][1];
		long max = queries[0][2];

		for (int i = 1; i < queries.length;i++) {

			idx1 = queries[i][0] > idx1 && queries[i][0] < idx2 ? queries[i][0] : idx1;
			idx2 = queries[i][1] < idx2 ? queries[i][1] : idx2;

			boolean f = queries[i][0] > idx1 && queries[i][0] < idx2;
		}

		System.out.println(max);
	}


	private static int[][] getQueries(int m) {

		int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        return queries;
	}
}