package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfPhoneNumber {

    /**
     * Backtracking
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        generate(digits, 0, result, map, new StringBuilder());

        return result;
    }

    private void generate(String digits, int level, List<String> result, Map<Character, String> map, StringBuilder state) {

        if (level == digits.length()) {
            if (state.length() != 0) {
                result.add(state.toString());
            }
            return;
        }

        String letters = map.get(digits.charAt(level));
        for (int i = 0; i < letters.length(); i++) {
            state.append(letters.charAt(i));
            generate(digits, level + 1, result, map, state);
            state.deleteCharAt(state.length() - 1);
        }
    }
}
