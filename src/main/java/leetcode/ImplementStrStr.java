package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/implement-strstr/
public class ImplementStrStr {

    /**
     * Implementation of the Boyer-Moore substring search algorithm
     * (mismatched character heuristic)
     * <p>
     * Time: O(N * M), where N is a length of the text and M is a length of the pattern
     * Space: O(K), where K is a number of unique symbols in the pattern
     */
    private static int strStr(String text, String pattern) {
        int t = text.length();
        int p = pattern.length();

        if (p == 0) {
            return 0;
        }

        Map<Character, Integer> lookup = new HashMap<>();
        for (int i = 0; i < p; i++) {
            lookup.put(pattern.charAt(i), i);
        }

        int skip;
        for (int i = 0; i <= t - p; i += skip) {
            skip = 0;
            for (int j = p - 1; j >= 0; j--) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    skip = j - lookup.getOrDefault(text.charAt(i + j), -1);
                    break;
                }
            }

            if (skip < 0) {
                skip = 1;
            }

            if (skip == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String... args) {
        int idx = strStr("hello", "ll");
        Assertions.assertEquals(idx, 2);
    }
}
