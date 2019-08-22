package hashmap;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string
public class FirstUniqueCharacter {

    public static void main(String... args) {
        Assertions.assertTrue(firstUniqCharUsingMap("aba") == 1);
        Assertions.assertTrue(firstUniqChar("abab") == -1);
    }

    // using hash map
    private static int firstUniqCharUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // in general, faster than the approach with map. However, it supports only lowercase letters
    private static int firstUniqChar(String s) {
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

        return idx == Integer.MAX_VALUE? -1 : idx;
    }
}
