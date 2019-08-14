public class PalindromeLinkedList {

    public static void main(String... s) {
        ListNode head = prepare();
        boolean b = isPalindrome(head);

        System.out.println(b);
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        //reach the middle of the list
        ListNode s = head.next;
        ListNode f = head.next.next;
        while (s != null && f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        //reverse
        ListNode prev = null;
        while(s.next != null) {
            ListNode next = s.next;
            s.next = prev;
            prev = s;
            s = next;
        }
        s.next = prev;

        // compare
        while (s != null) {
            if (head.val != s.val) {
                return false;
            }
            head = head.next;
            s = s.next;
        }

        return true;
    }

    private static ListNode prepare() {
        ListNode head = new ListNode(1);
        ListNode n = head.next = new ListNode(2);
        n.next = new ListNode(2);
        n.next = new ListNode(1);

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
