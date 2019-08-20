/**
* https://leetcode.com/problems/reverse-integer/
*/
public class ReverseInteger {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);

		System.out.println(reverse(num));
	}

	private static int reverse(int x) {

		int result = 0;

		while (x != 0) {

			int part = x % 10;
			x /= 10;

			if (shouldExpectOverflow(result, part)) {
				return 0;
			}

			result = result * 10 + part;
		}	

		return result;
	}

	private static boolean shouldExpectOverflow(int res, int part) {
		//max int = 214748364(7)
		if (res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE && part > 7) {
			return true;
		}

		//min int = -214748364(8)
		if (res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE && part < -8) {
			return true;
		}

		return false;
	} 
}