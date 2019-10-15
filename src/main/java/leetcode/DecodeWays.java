package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {

    /**
     * Dynamic programming.
     * <p>
     * A number is valid if it is within a range 1-26 or if it consists of pair of digits that also valid (inclusive)
     * Now, let's try several examples
     * <p>
     * 1 digit number can be decoded using 1 way only (2 -> B)
     * 2 valid digit number can be decoded using 2 way (22 -> BB, V)
     * 3 valid digit number can be decoded using 3 way (222 -> BBB, VB, BV)
     * 4 valid digit number can be decoded using 5 way (2222 -> BBBBB, VV, BBV, BVB, VBB)
     * 5 using 8 ways, 9 using 13 ways etc
     * <p>
     * So, it is like generating fibonacci sequence.
     * The only things that we should watch out for are "0" and numbers that are greater than "26"
     * as they can't be mapped to a letter.
     * <p>
     * Time: O(N), where N is length of the string
     * Space: O(1)
     */
    private static int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int prevprev = 0;
        int prev = 1; // a single digit will always map to a letter

        for (int i = 0; i < s.length(); i++) {
            int temp = prev;

            if (s.charAt(i) == '0') {
                prev = 0;
            }

            if (i > 0 && (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7')) {
                prev += prevprev;
            }

            prevprev = temp;
        }

        return prev;
    }

    public static void main(String s) {
        Assertions.assertEquals(numDecodings("222222"), 13);
    }
}
