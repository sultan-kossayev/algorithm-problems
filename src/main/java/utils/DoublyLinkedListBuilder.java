package utils;

public class DoublyLinkedListBuilder {

    public static class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
