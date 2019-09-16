package leetcode;

import org.junit.jupiter.api.Assertions;

import static utils.SinglyLinkedListBuilder.ListNode;

// https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedLists {

    /**
     * Once either of the lists reaches the end, point it to the head of the other list.
     * The idea behind this logic is that a + b = b + a
     * <p>
     * Time: O(N + M), where N and M are a number of nodes in each list
     * Space: O(1)
     */
    private static ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return null;
        }

        ListNode aHead = a;
        ListNode bHead = b;

        while (a != b) {
            a = a == null ? bHead : a.next;
            b = b == null ? aHead : b.next;
        }

        return a;
    }

    public static void main(String... args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        list1.next.next.next = new ListNode(6);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = list1.next.next;
        list2.next.next.next = list1.next.next.next;

        ListNode intersection = getIntersectionNode(list1, list2);
        Assertions.assertEquals(list1.next.next, intersection);
        Assertions.assertEquals(list2.next.next, intersection);
    }
}
