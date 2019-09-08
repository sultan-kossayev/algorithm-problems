package leetcode;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {

    /**
     * Using stack data structure
     * <p>
     * Time: O(n)
     * Space: O(n)
     */
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default: {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String... args) {
        boolean valid = isValid("{()}[]");
        boolean invalid = !isValid("{()}[}");

        Assertions.assertTrue(valid);
        Assertions.assertTrue(invalid);
    }
}
