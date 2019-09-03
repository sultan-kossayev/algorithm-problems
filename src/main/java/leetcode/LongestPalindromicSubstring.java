package leetcode;

import org.junit.jupiter.api.Assertions;

public class LongestPalindromicSubstring {

    /**
     * Let's say that a string starts with [i] index and ends with [j] index.
     * <p>
     * Then we can say that the string is palindrome if [i] and [j] are equal
     * AND either of the below is true
     * 1. the string consists of maximum 3 character.
     * For example: "a", "bab" are palindrome, but "ba" is not because "b" != a"
     * 2. the string that's sits in the middle. that starts with [i+1] and ends with [j-1] index is also palindrome.
     * For example: "bcacb" is a palindrome because "cac" is palindrome
     * <p>
     * Time: O(n^2), where N is length of the string
     * Space: O(N^2)
     */
    private static String longestPalindrome1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        // follow DP techniques
        // cache table stores information about whether a string is palindrome
        // the first index of the cache defines the start position of the string
        // the second index defines the end of the string
        // for example, for given "abababcad" string
        // cache[1][4] is true, because "babab" is a palindrome
        // cahce[5][7] is false, because "cad" is not a palindrome
        boolean[][] cache = new boolean[s.length()][s.length()];

        int maxLength = -1; // the length of the longest palindrome so far
        int start = -1, end = -1; // the start and end of the longest palindrome

        // a nice technique to traverse the string backwards
        // so "bababcac" will be traversed as "c", then "ac", then "cac", then "bcac" and so forth
        // this way when we reach "babab" we will already traversed "aba" thus
        // we will already know whether "aba" is a palindrome or not
        // because it was processed at the previous step
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                // checking two conditions that are described in the description of the algorithm above
                cache[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || cache[i + 1][j - 1]);

                if (cache[i][j] && j - i > maxLength) {
                    start = i;
                    end = j;
                    maxLength = j - i;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * Let's say that a string starts with [i] index and ends with [j] index and
     * the string has k-th element, i <= k <= j.
     * Then we can detemine whether k-th element is a part of palindrome by checking
     * whether s[k-1] == s[k+1], s[k-2] == s[k+2] and so one.
     * Thus, you can imagine as if we are extending our search to left and right directions starting from the k position.
     * The search continue until we reach the i and j position or s[k - x] != s[k + x], where x is expansion radius.
     * <p>
     * For example: "cbaeabd", we start from "e" and expand to left and right: "a"=="a", "b"="b", "c"!="d".
     * Thus, our answer is "baeab"
     * <p>
     * Time: O(N^2), where N is a length of the string
     * Space: O(1)
     */
    private static String longestPalindrome2(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int[] p = new int[2]; // start and end of the found palindrome
        int maxLength = -1; // // the length of the longest palindrome so far

        // start from the first element and expand every element to left and right
        for (int k = 0; k < s.length(); k++) {
            maxLength = expandToLeftAndRight(s, k, k, maxLength, p); // if the palindrome has odd length
            maxLength = expandToLeftAndRight(s, k, k + 1, maxLength, p); // if the palindrome has even length
        }

        return s.substring(p[0], p[1]);
    }

    private static int expandToLeftAndRight(String s, int left, int right, int maxLength, int[] p) {
        // as we expanding we check whether the chars are equal
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left = left + 1; //to compensate the decrement operation that happens on the last step of the above loop

        if (right - left > maxLength) {
            maxLength = right - left;
            p[0] = left;
            p[1] = right;
        }

        return maxLength;
    }

    public static void main(String... args) {
        String p1 = longestPalindrome1("bababcac");
        Assertions.assertEquals(p1, "babab");

        String p2 = longestPalindrome2("bababcac");
        Assertions.assertEquals(p2, "babab");
    }
}
