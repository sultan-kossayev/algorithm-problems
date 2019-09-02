package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class GenerateParentheses {

    /**
     * Solved using backtracking.
     * The algorithm follows the intuition that each "open" parenthesis will require "closed" parenthesis later.
     * Thus, whenever we open a parenthesis we increment a number of parentheses that we have close later.
     */
    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        generate(res, new StringBuilder(), 0, 0, n);

        return res;
    }

    private static void generate(List<String> res, StringBuilder temp, int opened, int needToClose, int n) {

        if (temp.length() == n * 2) {   // our goal
            res.add(temp.toString());
            return;
        }

        if (opened < n) {
            temp.append("(");
            // increment a number of opened parentheses and parentheses that we have to close later
            generate(res, temp, opened + 1, needToClose + 1, n);
            temp.setLength(temp.length() - 1);  // backtrack
        }

        if (needToClose > 0) {
            temp.append(")");
            // decrement a number of closed parentheses
            generate(res, temp, opened, needToClose - 1, n);
            temp.setLength(temp.length() - 1);  // backtrack
        }
    }

    public static void main(String... args) {
        List<String> res = generateParenthesis(3);

        Assertions.assertTrue(res.toString().equals("[((())), (()()), (())(), ()(()), ()()()]"));
    }
}
