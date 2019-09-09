package leetcode;

import org.junit.jupiter.api.Assertions;

// https://leetcode.com/problems/min-stack/
public class MinStack {

    /**
     * The logic is that every node should know about
     * the minimum value that was relevant at the time when that node was pushed to the stack
     * i.e.
     * for nodes [5->6->2->8->4->3] (5 is the head)
     * the minimums that they hold will be [5(2)->6(2)->2(2)->8(3)->4(3)->3(3)->10(10)], where (value) is the minimum
     * <p>
     * Time: O(1) for all stack operations.
     * Space: O(N), where N is a number of nodes in the stack
     */
    ListNode head;

    public static void main(String... args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        Assertions.assertEquals(stack.getMin(), -3);
        stack.pop();
        Assertions.assertEquals(stack.top(), 0);
        Assertions.assertEquals(stack.getMin(), -2);
    }

    public void push(int x) {
        if (head == null) {
            head = new ListNode(x, x, null);
        } else {
            head = new ListNode(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class ListNode {
        int min;
        int val;
        ListNode next;

        ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
