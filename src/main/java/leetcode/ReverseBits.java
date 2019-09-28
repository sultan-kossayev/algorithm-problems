package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/reverse-bits/
public class ReverseBits {

    private static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // shift left and OR last bit
            res = (res << 1) | (n & 1);
            n >>>= 1;
        }

        return res;
    }

    public static void main(String... args) {
        int num = reverseBits(43261596);

        Assertions.assertEquals(num, 964176192);
    }
}
