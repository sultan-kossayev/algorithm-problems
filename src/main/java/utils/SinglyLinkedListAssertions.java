package utils;

import org.junit.jupiter.api.Assertions;

public class SinglyLinkedListAssertions {

    public static void assertEqual(SinglyLinkedListBuilder.ListNode head, int[] nums) {
        int i = 0;
        while(head != null) {
            Assertions.assertEquals(head.val, nums[i++]);
            head = head.next;
        }
    }
}
