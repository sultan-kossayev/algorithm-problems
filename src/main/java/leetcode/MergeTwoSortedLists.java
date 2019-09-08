package leetcode;

import utils.SinglyLinkedListAssertions;
import utils.SinglyLinkedListBuilder;
import utils.SinglyLinkedListBuilder.ListNode;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {

    /**
     * Time: O(N + M), where N is a size of l1 and M is a size of l2
     * Space: O(1)
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode head = fake;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;
        }

        // adding the remainder
        head.next = l1 != null ? l1 : l2;

        return fake.next;
    }

    public static void main(String[] args) {
        ListNode l1 = SinglyLinkedListBuilder.build(1, 2, 4);
        ListNode l2 = SinglyLinkedListBuilder.build(2, 3, 5);
        ListNode merged = mergeTwoLists(l1, l2);
        SinglyLinkedListAssertions.assertEqual(merged, 1, 2, 2, 3, 4, 5);
    }
}
