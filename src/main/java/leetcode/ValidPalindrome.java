package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {

    /**
     * Two pointers: head and tail
     * <p>
     * Time: O(N), N is a length of the string
     * Space: O(1)
     */
    private static boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;

        boolean valid = true;
        while (head < tail) {
            char c1 = Character.toLowerCase(s.charAt(head));
            char c2 = Character.toLowerCase(s.charAt(tail));

            if (Character.isLetterOrDigit(c1) && Character.isLetterOrDigit(c2)) {
                if (c1 != c2) {
                    valid = false;
                    break;
                }
                head++;
                tail--;
            } else {
                if (!Character.isLetterOrDigit(c1)) {
                    head++;
                }
                if (!Character.isLetterOrDigit(c2)) {
                    tail--;
                }
            }
        }

        return valid;
    }

    public static void main(String... args) {
        boolean valid = isPalindrome("A man, a plan, a canal: Panama");
        Assertions.assertTrue(valid);
    }
}
