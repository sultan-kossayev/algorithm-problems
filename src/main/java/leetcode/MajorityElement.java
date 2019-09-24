package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {

    /**
     * Implementation of Boyer-Moore majority voting algorithm:
     * "We will sweep down the sequence starting at the pointer position shown above.
     * As we sweep we maintain a pair consisting of a current candidate and a counter.
     * Initially, the current candidate is unknown and the counter is 0.
     * When we move the pointer forward over an element e:
     * If the counter is 0, we set the current candidate to e and we set the counter to 1.
     * If the counter is not 0, we increment or decrement the counter according to whether e is the current candidate.
     * When we are done, the current candidate is the majority element, if there is a majority."
     * <p>
     * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
     * <p>
     * Time: O(N)
     * Space: O(1)
     */
    private static int majorityElement(int[] nums) {

        int candidate = -1;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
                count++;
            } else {
                count = candidate == n ? count + 1 : count - 1;
            }
        }

        return candidate;
    }

    public static void main(String... args) {
        int n = majorityElement(new int[]{2, 2, 3, 1, 2, 6});
        Assertions.assertEquals(2, n);
    }
}
