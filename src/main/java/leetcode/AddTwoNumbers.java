package leetcode;

import utils.SinglyLinkedListAssertions;
import utils.SinglyLinkedListBuilder;

import static utils.SinglyLinkedListBuilder.ListNode;

// https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbers {

    /**
     * Simulating digits-by-digits sum starting from the head of list
     *
     * Things to remember:
     *  - lists can vary by size
     *  - keep track of the carry
     *  - summing two digits may "overflow"
     *
     *  Time: O(max(N, M)), where N is a number of elements from l1 list, M are elements from l2
     *  Space: 0(1)
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode head = fake;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int l1Num = 0;
            int l2Num = 0;
            if (l1 != null) {
                l1Num = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Num = l2.val;
                l2 = l2.next;
            }

            int s = l1Num + l2Num + carry;

            carry = s / 10;
            int res = s % 10;

            head.next = new ListNode(res);
            head = head.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return fake.next;
    }


    public static void main(String... args) {
        ListNode list1 = SinglyLinkedListBuilder.build(9,9);
        ListNode list2 = SinglyLinkedListBuilder.build(9,9);

        ListNode sum = addTwoNumbers(list1, list2);

        SinglyLinkedListAssertions.assertEqual(sum, new int[]{8,9,1});
    }
}
