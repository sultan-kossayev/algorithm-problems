package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Using sliding window technique.
     * The head pointer is used to scan the string.
     * The tail pointer is used to calculate distance of a substring
     * once we encounter a duplicated character.
     * <p>
     * Time: O(N), where N is a length of the string
     * Space: O(M), where M is a number of unique chars in the string
     */
    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();

        int max = 0;
        int tail = 0;
        for (int head = 0; head < s.length(); head++) {
            char c = s.charAt(head);

            if (seen.containsKey(c)) {
                int prevIdx = seen.get(c);
                // tail is updated when we reach a duplicated character in a substring
                // however, before we update the tail we have to check whether a found duplicated character
                // is behind the current position of the tail
                // if yes, then the tail can't be updated
                // for example, in "wobgrovw" string when we reach 2nd "w" (7th index), the tail is already on
                // 2nd position because "o" was already processed and because 1st "w" is in 0 index and 0 < 2
                // thus we can't update the tail.
                // Otherwise, it would give us incorrect answer later when we calculate the distance
                // For example:
                // incorrect_distance = 7 (head) - 1 (incorrect tail) + 1 = 7; (if we update the tail every time)
                // correct_distance = 7 (head) - 2 (correct tail) + 1 = 6; (if we keep our Math.max() statement)
                tail = Math.max(tail, prevIdx + 1);
            }

            seen.put(c, head);

            int distance = head - tail + 1;
            max = Math.max(max, distance);
        }

        return max;
    }

    public static void main(String[] args) {
        int maxLength = lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(maxLength, 3);
    }
}
