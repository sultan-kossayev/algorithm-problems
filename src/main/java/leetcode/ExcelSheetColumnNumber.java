package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/excel-sheet-column-number/
public class ExcelSheetColumnNumber {

    /**
     * Treat as base 26 system
     * <p>
     * Time: O(N), where N is a length of the string
     * Space: O(1)
     */
    private static int titleToNumber(String s) {
        int column = 0;
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            column = column * 26 + (s.charAt(i) - 'A' + 1);
        }

        return column;
    }

    public static void main(String... args) {
        Assertions.assertEquals(titleToNumber("ZZ"), 702);
    }
}
