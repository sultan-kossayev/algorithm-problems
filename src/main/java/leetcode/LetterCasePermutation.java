package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {

    /**
     * Use backtracking and represent permutation options as DFS.
     * <p>
     * Time: O(N * 2^n)
     * Space: O(N * 2^n)
     */
    private static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        collect(res, S.toCharArray(), 0);

        return res;
    }

    private static void collect(List<String> res, char[] in, int idx) {
        res.add(new String(in));

        for (int i = idx; i < in.length; i++) {
            char c = in[i];
            if (Character.isLetter(c)) {  // the constraint
                char cNew = Character.isLowerCase(c) ? (char) (c - 32) : (char) (c + 32);
                in[i] = cNew; // transform
                collect(res, in, i + 1);
                in[i] = c;   // backtrack
            }
        }
    }

    public static void main(String... args) {
        List<String> res = letterCasePermutation("a1b2");

        Assertions.assertTrue(res.equals(Arrays.asList(new String[]{"a1b2", "A1b2", "A1B2", "a1B2"})));
    }
}
