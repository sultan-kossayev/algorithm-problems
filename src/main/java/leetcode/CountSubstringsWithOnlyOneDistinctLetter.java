package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
public class CountSubstringsWithOnlyOneDistinctLetter {

    /**
     * Just count the distinct letters from left to right.
     * <p>
     * Time: O(n)
     * Space: O(1)
     */
    private static int countLetters(String s) {
        int count = 0;
        int similar = 1;
        for (int i = 0; i < s.length() - 1; i++, similar++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count += similar * (similar + 1) / 2;
                similar = 0;
            }
        }

        return count + similar * (similar + 1) / 2;
    }

    public static void main(String... args) {
        int count = countLetters("aaaba");
        Assertions.assertEquals(count, 8);
    }
}
