/*
* Emma is playing a new mobile game that starts with consecutively numbered clouds. 
* Some of the clouds are thunderheads and others are cumulus. 
* She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  1 or 2. 
* She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. 
* It is always possible to win the game.

*/

import java.util.Scanner;

public class CloudJumping {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String... args) {
		//int n = 7;
		int n = Integer.parseInt(scanner.nextLine());

		//int[] c = {0, 0, 1, 0, 0, 1, 0};
		int[] c = getArr(n);

		int step = 0;
		int i = 0;
		while (i < c.length - 1) {
			int first = c[Math.min(i + 1, c.length - 1)];
			int second = c[Math.min(i + 2, c.length - 1)];

			i = second == 0? i + 2: i + 1;

			step++;
		}

		System.out.println(step);
	}

	private static int[] getArr(int n) {
		String[] arItems = scanner.nextLine().split(", ");

		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        return ar;
	}
}