package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    /**
     * Using hash table
     * <p>
     * Time: O(N), the length of the string s or t
     * Space: O(1), the length of the hash table is fixed
     */
    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];
        for (char ch : s.toCharArray()) {
            table[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            if (--table[ch - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        boolean valid = isAnagram("anagram", "margana");
        boolean invalid = !isAnagram("ab", "ac");
        Assertions.assertTrue(valid);
        Assertions.assertTrue(invalid);
    }
}
