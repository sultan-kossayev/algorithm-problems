import java.util.Arrays;

// https://leetcode.com/problems/plus-one
public class PlusOne {
	
	public static void main(String[] args) {
		int[] digits = new int[]{1,2,3};
		int[] res = plusOne(digits);

		System.out.println(Arrays.toString(res));
	}

	private static int[] plusOne(int[] digits) {       
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int r = digits[i] + 1;
            
            if (r == 10) {
                digits[i] = 0;
            } else {
                digits[i] = r;
                return digits;
            }
        }
        
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        
        return res;
    }
}