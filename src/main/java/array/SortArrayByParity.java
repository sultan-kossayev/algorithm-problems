
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
* https://leetcode.com/problems/sort-array-by-parity/
*/
public class SortArrayByParity {
	
	public static void main(String... args) {
		int[] arr = new int[]{4, 1,3,6,1,2,4};

		System.out.println(Arrays.toString(sortArrayByParity(arr)));
	}

	private static int[] sortArrayByParity(int[] A) {
		int i = 0, j = A.length - 1;

		while (i < j) {
			if (A[i] % 2 > A[j] % 2) {
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
			}

			if (A[i] % 2 == 0) {
				i++;
			}

			if (A[j] % 2 != 0) {
				j--;
			}
		}

		return A;
    }
}