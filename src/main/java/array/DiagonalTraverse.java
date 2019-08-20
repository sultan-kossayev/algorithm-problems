import java.util.Arrays;

//https://leetcode.com/problems/diagonal-traverse
public class DiagonalTraverse {

	public static void main(String... args) {

		int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};

		int[] res = findDiagonalOrder(matrix);
		System.out.println(Arrays.toString(res));
	}

	//Idea is the following
    //notice all values in the same diagonal share the same sum value of x index + y index
    //direction of going up right or going down left depends whether the index sum is even or odd
    //for each even or odd diagonal, there are three cases:
	// 1. there is room to go that direction 
	// 2. there is no row space to go further but there is col space 
	// 3. there is no col space to go further but there is row space
	private static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];
        
        int r = 0, c = 0;
        for (int i = 0; i < rows * cols;i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // up
                if ( (r - 1) >= 0 && (c + 1) < cols) { // both
                    r = r - 1;
                    c = c + 1;
                } else if ((r - 1) < 0 && (c + 1) < cols) { //-> col
                    c = c + 1;
                } else if ((r + 1) < rows && (c + 1) >= cols) { //-> rows
                    r = r + 1;
                }
            } else { // down
                if ( (r + 1) < rows && (c - 1) >= 0) { // both
                    r = r + 1; 
                    c = c - 1;
                } else if ( (r + 1) < rows && (c - 1) < 0) { //-> row
                    r = r + 1;
                } else if ( ( r + 1) >= rows && (c + 1) < cols) { //-> cols
                    c = c + 1;
                }
            }
        }
        
        return res;
    }
}