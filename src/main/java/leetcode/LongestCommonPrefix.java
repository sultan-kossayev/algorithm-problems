package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

    /**
     * Vertical scanning
     * <p>
     * Time: O(S), where S is a sum of lengths of all strings
     * Space: O(1)
     */
    private static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }

    /**
     * Divide and conquer
     * <p>
     * Time: O(S)
     * Space: O(M * log N), N recursive calls, each call allocates M additional space (substring call)
     */
    private static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return findPrefix(strs, 0, strs.length - 1);
    }

    private static String findPrefix(String[] strs, int lo, int hi) {
        if (hi <= lo) {
            return strs[lo];
        }

        int p = (lo + hi) / 2;

        String common1 = findPrefix(strs, lo, p);
        String common2 = findPrefix(strs, p + 1, hi);

        int i;
        for (i = 0; i < Math.min(common1.length(), common2.length()); i++) {
            if (common1.charAt(i) != common2.charAt(i)) {
                break;
            }
        }

        return common1.substring(0, i);
    }

    public static void main(String... args) {
        String prefix1 = longestCommonPrefix1(new String[]{"flower", "flow", "flight"});
        Assertions.assertEquals(prefix1, "fl");

        String prefix2 = longestCommonPrefix2(new String[]{"flower", "flow", "flight"});
        Assertions.assertEquals(prefix2, "fl");
    }
}
