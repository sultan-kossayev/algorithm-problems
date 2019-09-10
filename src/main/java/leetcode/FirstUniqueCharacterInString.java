package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/
public class FirstUniqueCharacterInString {

    /**
     * Using char map. Supports only limited types of characters
     * <p>
     * Time: O(N), N is a length of string string
     * Space: O(1)
     */
    private static int firstUniqChar1(String s) {
        int[] counts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            counts[c] = counts[c] + 1;
        }

        int uniqueIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (counts[(int) s.charAt(i)] == 1) {
                uniqueIdx = i;
                break;
            }
        }

        return uniqueIdx;
    }

    /**
     * Using hash map
     * <p>
     * Time: O(N)
     * Space: O(1), hash map will contain only limited types characters amount of which is constant
     */
    private static int firstUniqChar2(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            seen.put(c, seen.getOrDefault(c, 0) + 1);
        }

        int uniqueIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (seen.get(s.charAt(i)) == 1) {
                uniqueIdx = i;
                break;
            }
        }

        return uniqueIdx;
    }

    /**
     * In general, faster than approach with map. However, it supports only lowercase letters
     * <p>
     * Time: O(N)
     * Space: O(1)
     */
    private static int firstUniqChar3(String s) {
        if (s == null || s.isEmpty()) {
            return -1;
        }

        int idx = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);

            if (first != -1 && first == last) {
                idx = Math.min(idx, first);
            }
        }

        return idx == Integer.MAX_VALUE ? -1 : idx;
    }

    public static void main(String... args) {
        String str = "welcome, world";
        int idx1 = firstUniqChar1(str);
        int idx2 = firstUniqChar2(str);
        int idx3 = firstUniqChar3(str);

        Assertions.assertTrue(3 == idx1 && idx2 == idx3);
    }
}
