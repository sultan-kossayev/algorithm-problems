package leetcode;

import utils.SinglyLinkedListAssertions;
import utils.SinglyLinkedListBuilder;

import static utils.SinglyLinkedListBuilder.ListNode;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {

    /**
     * Time: O(N), number of nodes in the linked list
     * Space: O(1)
     */
    private static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    /**
     * Time: O(N)
     * Space: O(N), recursive calls
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList2(head.next);

        // this does the main trick
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String... args) {
        ListNode list1 = SinglyLinkedListBuilder.build(1, 2, 3, 4, 5);
        ListNode l1 = reverseList1(list1);

        SinglyLinkedListAssertions.assertEqual(l1, 5, 4, 3, 2, 1);

        ListNode list2 = SinglyLinkedListBuilder.build(1, 2, 3, 4, 5);
        ListNode l2 = reverseList2(list2);
        SinglyLinkedListAssertions.assertEqual(l2, 5, 4, 3, 2, 1);
    }
}
