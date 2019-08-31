package leetcode;

import utils.DoublyLinkedListBuilder.ListNode;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/lru-cache/
public class LRUCache {

    /**
     * Implementation notes.
     * <p>
     * LRU cache requires 2 things: fast lookup for the key and fast removal of LRU key if the cache is full.
     * We are going to use hash map to guarantee fast lookup. Fast removal will be done using doubly linked list.
     * Doubly linked list will also help to track the position of the cache item in the cache.
     * <p>
     * Basic algorithm is
     * 1. every time when an item is processed in (inserted into/updated in/retrieved from cache), the item
     * is placed to the head of the cache.
     * 2. this way items that are processed less frequently will always be shifting towards the end of the cache.
     * 3. thus, LRU item is an item which sits at the end of the cache
     * <p>
     * Time: O(1) to get and put a cache item
     * Space: O(capacity), where capacity is size of the cache
     */
    private Map<Integer, ListNode> cache;

    private ListNode head;
    private ListNode tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.cache = new HashMap<>();
    }

    public static void main(String... args) {
        LRUCache lruCache = new LRUCache(2);
        assertEquals(lruCache.get(1), -1);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3); // at this point, key 1 is going to be removed from cache as LRU

        assertEquals(lruCache.get(1), -1);
        assertEquals(lruCache.get(2), 2); // key 2 is moved to head

        lruCache.put(4, 4); // at this point, key 3 is going to be removed from cache as LRU
        assertEquals(lruCache.get(3), -1);
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        int value = node.value;

        if (node.prev != head) { // no need to move the node if it already in the beginning of the cache
            unlinkNode(node);
            moveToHead(node);
        }

        return value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            evictIfNeeded();

            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            moveToHead(newNode);
        } else {
            node.value = value;

            if (node.prev != head) { // no need to move the node if it already in the beginning of the cache
                unlinkNode(node);
                moveToHead(node);
            }
        }
    }

    // before putting the new element check the size of the cache
    private void evictIfNeeded() {
        if (cache.size() == capacity) {
            ListNode node = tail.prev;

            unlinkNode(node);

            cache.remove(node.key);
        }
    }

    // preparing the node to get removed or moved to the head later
    private void unlinkNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // moving the node to the beginning of the cache
    private void moveToHead(ListNode node) {
        // inject
        node.prev = head;
        node.next = head.next;

        // establish the links
        head.next.prev = node;
        head.next = node;
    }
}