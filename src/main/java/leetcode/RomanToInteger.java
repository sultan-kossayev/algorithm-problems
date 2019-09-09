package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {

    /**
     * Just use the lookup table that is smart enough to
     * handle I, X, C exceptions
     * <p>
     * Time: O(N), N is a length of the string
     * Space: O(1)
     */
    private static int romanToInt(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += value(i, s);
        }

        return res;
    }

    private static int value(int cursor, String s) {
        char c = s.charAt(cursor);
        char next = cursor + 1 < s.length() ? s.charAt(cursor + 1) : '0';

        // lookup table
        if (c == 'V') {
            return 5;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M') {
            return 1000;
        } else if (c == 'I') {
            return next == 'V' || next == 'X' ? -1 : 1;
        } else if (c == 'X') {
            return next == 'L' || next == 'C' ? -10 : 10;
        } else { // else if(c == 'C') {
            return next == 'D' || next == 'M' ? -100 : 100;
        }
    }

    public static void main(String... args) {
        Assertions.assertEquals(romanToInt("IV"), 4);
        Assertions.assertEquals(romanToInt("MCMXCIV"), 1994);
    }
}
