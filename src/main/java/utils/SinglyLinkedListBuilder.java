package utils;

public class SinglyLinkedListBuilder {

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static ListNode build(int... nums) {
        ListNode sentinel = new ListNode(-1);
        ListNode head = sentinel;
        for (int i = 0; i < nums.length;i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }

        return sentinel.next;
    }
}
