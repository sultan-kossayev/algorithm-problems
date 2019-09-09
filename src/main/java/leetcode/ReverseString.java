package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {

    /**
     * Replace chars from the 2 ends one by one and move towards the middle
     * <p>
     * Time: O(N), N is a length of the string
     * Space: O(1)
     */
    private static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String... args) {
        char[] s = new char[]{'w', 'e', 'l', 'c', 'o', 'm', 'e'};
        reverseString(s);
        Assertions.assertArrayEquals(s, new char[]{'e', 'm', 'o', 'c', 'l', 'e', 'w'});
    }
}
