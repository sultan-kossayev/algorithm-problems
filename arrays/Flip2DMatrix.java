import java.util.*;

// https://www.firecode.io/pages/explore/402112
public class Flip2DMatrix {
	
	public static void main(String... args) {
		int[][] matrix = {{1, 2}, {1, 3}};

		flipItVerticalAxis(matrix);

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

	private static void flipItVerticalAxis(int[][] matrix) {
	    for (int i = 0; i < matrix.length; i++) {
	        int M = matrix[i].length;
	        for (int j = 0; j < M / 2;j++) {
	            int t = matrix[i][j];
	            matrix[i][j] = matrix[i][M - j - 1];
	            matrix[i][M - j - 1] = t;
	        }
	    }
	}
}