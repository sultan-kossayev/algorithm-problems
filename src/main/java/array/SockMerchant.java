import java.util.*;

/**
*
* It must print an integer representing the number of matching pairs of numbers contained in the array.
* Input: n is a number of integers in the array, ar is a array with numbers
* 
* Time complexity: O(n(logn))
* Space complexity: O(n)
*/
public class SockMerchant {
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String... args) {	
		// int n = 9;
		int n = Integer.parseInt(scanner.nextLine());

		//int[] ar = {10 20 20 10 10 30 50 10 20};
		int[] ar = 	getArr(n);

		Arrays.sort(ar);

		int k = 0;
		for (int i = 0; i < ar.length - 1;i++) {
			if (ar[i] == ar[i + 1]) {
				k++;
				i++;
			}
		}

		System.out.println(k);
	}

	private static int[] getArr(int n) {
		String[] arItems = scanner.nextLine().split(" ");

		int[] ar = new int[n];

		for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        
        return ar;
	}
}