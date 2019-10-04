package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {

    /**
     * Use hash map to quickly identify a group which string belongs to
     * <p>
     * Time: O(S * L), S is a size of the input array, L is a length of longest string from the input array
     * Space: O(S * L)
     */
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String chars = getSignature(str);
            if (map.containsKey(chars)) {
                map.get(chars).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(chars, l);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String getSignature(String s) {
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        return String.valueOf(chars);
    }

    public static void main(String... args) {
        List<List<String>> groups = groupAnagrams(new String[]{"ate", "eat", "dog", "god"});
        Assertions.assertLinesMatch(groups.get(0), Arrays.asList("ate", "eat"));
        Assertions.assertLinesMatch(groups.get(1), Arrays.asList("dog", "god"));
    }
}
