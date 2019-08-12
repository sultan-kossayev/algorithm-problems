// https://leetcode.com/problems/reverse-linked-list/
public class ReverseSinglyLinkedList {

    public static void main(String... args) {
        ListNode head = prepare();
        toString(reverseListIteratively(head));

        ListNode head2 = prepare();
        toString(reverseListRecursively(head2));
    }

    private static ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    private static ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    private static ListNode prepare() {
        ListNode head = new ListNode(1);
        ListNode n = head.next = new ListNode(2);
        n.next = new ListNode(3);

        return head;
    }
    private static void toString(ListNode head) {
        ListNode ln = head;
        while(ln != null) {
            System.out.print (ln.val + " ");
            ln = ln.next;
        }

        System.out.println();
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
