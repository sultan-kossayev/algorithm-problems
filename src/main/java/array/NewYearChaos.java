import java.util.Scanner;

/**
* https://www.hackerrank.com/challenges/new-year-chaos/problem
*/
public class NewYearChaos {


	private static Scanner scanner = new Scanner(System.in);

	public static void main(String... args) {

		int n = Integer.parseInt(scanner.nextLine());
		int[] q = getQueue(n);

		int bribes = 0;
		boolean chaotic = false;

		/**
		* All we need to do is to count the number of people who overtake a person.
		*/
		for (int i = 0; i < n;i++) {
			if (q[i] - (i + 1) > 2) {
				System.out.println("Too chaotic");
				chaotic = true;
				break;
			}

			for (int j = Math.max(0, q[i] - 2);j < i;j++) {
				if (q[j] > q[i]) {
					bribes++;
				}
			}
		}

		if (!chaotic) {
			System.out.println(bribes);
		}
	}

	private static int[] getQueue(int n) {
		String[] aItems = scanner.nextLine().split(" ");

		int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        return a;
	}
}