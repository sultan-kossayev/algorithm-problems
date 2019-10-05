package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

    /**
     * 1. the farther the lines the more will be the area
     * 2. the area formed between 2 lines will always be limited by the shorter one
     * 3. once we identified the shorter line, we should check the line which is next or before it, because
     * we will never get the bigger area that we have already if we stay on this line.
     * So, we should move on and hope that there will a higher line.
     * <p>
     * Time: O(N), N is a size of the array
     * Space: O(1)
     */
    private static int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int capacity = 0;
        while (lo < hi) {
            capacity = Math.max(capacity, Math.min(height[lo], height[hi]) * (hi - lo));
            if (height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }

        return capacity;
    }

    public static void main(String... args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        int area = maxArea(height);

        Assertions.assertEquals(area, 49);
    }
}
