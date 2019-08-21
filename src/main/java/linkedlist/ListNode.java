package linkedlist;

import org.junit.jupiter.api.Assertions;

public class ListNode {

    public int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static ListNode prepare(int... vals) {
        ListNode head = null;
        ListNode prev = null;
        for (int i = 0; i < vals.length;i++) {
            ListNode ln = new ListNode(vals[i]);
            if (head == null) {
                head = ln;
                prev = head;
            } else {
                prev.next = ln;
                prev = ln;
            }
        }

        return head;
    }

    public static void assertAllEqual(ListNode head, int... vals) {
        int i = 0;
        while(head != null) {
            Assertions.assertTrue(head.val == vals[i]);
            i++;
            head = head.next;
        }
    }
}
