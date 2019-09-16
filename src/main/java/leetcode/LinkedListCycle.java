package leetcode;

import org.junit.jupiter.api.Assertions;
import utils.SinglyLinkedListBuilder.ListNode;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    /**
     * two pointers: slow and fast
     * <p>
     * Time: O(N), N is a size of the list
     * Space: O(1)
     */
    private static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String... args) {
        ListNode head = new ListNode(1);
        ListNode n = head.next = new ListNode(2);
        n.next = new ListNode(3);
        n.next = head;

        Assertions.assertTrue(hasCycle(head));
    }
}
