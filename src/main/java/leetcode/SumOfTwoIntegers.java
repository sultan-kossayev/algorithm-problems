package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/sum-of-two-integers/
public class SumOfTwoIntegers {

    /**
     * XOR simulates addition, however falls short with the carry
     * AND can be used to get the carry.
     * Left shifting is used to apply carry for next bits.
     */
    private static int getSum(int a, int b) {
        while (b != 0) {
            System.out.println(b);
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }

        return a;
    }

    public static void main(String... args) {
        int sum = getSum(4, 5);

        Assertions.assertEquals(sum, 9);
    }
}
