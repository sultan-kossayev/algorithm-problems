package linkedlist;

// https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveElements {

    public static void main(String[] args) {
        ListNode head = ListNode.prepare(new int[]{1,2,3,1,1,4,5,1});

        head = removeElements(head, 1);

        ListNode.assertAllEqual(head, 2,3,4,5);
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;

        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }

            head = head.next;
        }

        return fake.next;
    }
}
