package leetcode;

import utils.SinglyLinkedListAssertions;
import utils.SinglyLinkedListBuilder;

import static utils.SinglyLinkedListBuilder.build;

// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInLinkedList {

    /**
     * Time: O(1)
     * Space: O(1)
     */
    private static void deleteNode(SinglyLinkedListBuilder.ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String... args) {
        SinglyLinkedListBuilder.ListNode head = build(1, 2, 3, 4, 5);
        deleteNode(head.next);
        SinglyLinkedListAssertions.assertEqual(head, 1, 3, 4, 5);
    }
}
