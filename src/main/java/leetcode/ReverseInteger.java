package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {

    /**
     * "/" allows to reduce the number by 1 digit
     * "%" allows to get the last 1 digit
     * <p>
     * Time: O(N), N is a number of digits in x
     * Space: O(1)
     */
    private static int reverse(int x) {

        int result = 0;

        while (x != 0) {

            int part = x % 10;
            x /= 10;

            if (willOverflow(result, part)) {
                return 0;
            }

            result = result * 10 + part;
        }

        return result;
    }

    private static boolean willOverflow(int res, int part) {
        // max int = 2 147 483 647
        // because 2147483647 / 10 = 214748364
        // thus if res = 214748365 then the final result will overflow because 214748365 * 10 = 2147483650
        // also, if res = 214748364 then the fina; result will overflow only if part > 7 because 214748364 * 10 + 8 = 2147483648
        if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && part > 7)) {
            return true;
        }

        //min int = -214748364(8)
        // the same logic as above
        if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && part < -8)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int rev1 = reverse(123);
        Assertions.assertEquals(rev1, 321);
    }
}
