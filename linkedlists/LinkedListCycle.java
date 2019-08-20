// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    public static void main(String... args) {
        boolean has = hasCycle(prepare());

        System.out.println(has);
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    private static ListNode prepare() {
        ListNode head = new ListNode(1);
        ListNode n = head.next = new ListNode(2);
        n.next = new ListNode(3);
        n.next = head;

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
