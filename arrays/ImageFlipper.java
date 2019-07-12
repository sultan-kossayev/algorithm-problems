import java.util.Arrays;

/**
* https://leetcode.com/problems/flipping-an-image/
*/
public class ImageFlipper {

	public static void main(String... args) {

		int[][] arr = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		//int[][] arr = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
		//int[][] arr = new int[][]{{1, 0}, {0, 1}};

		int[][] res = flipAndInvertImage(arr);

		for (int[] r : res) {
			System.out.println(Arrays.toString(r));
		}
	}

	private static int[][] flipAndInvertImage(int[][] A) {
		int length = A.length;
		for (int[] a : A) {
			for (int i = 0; i < (length + 1) / 2; i++) {
				int t = a[i] ^ 1;
				a[i] = a[length - i - 1] ^ 1;
				a[length - i - 1] = t;
			}
		}

		return A;
    }
}