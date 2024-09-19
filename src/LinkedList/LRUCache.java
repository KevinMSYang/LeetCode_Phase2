//Question:146
//Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
//
//Implement the LRUCache class:
//
//LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
//int get(int key) Return the value of the key if the key exists, otherwise return -1.
//void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
//The functions get and put must each run in O(1) average time complexity.
//
// 
//
//Example 1:
//
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4

package LinkedList;

import java.util.Map;

class ListNode {
	int key;
	int val;
	ListNode next;
	ListNode prev;
	
	public ListNode(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
public class LRUCache {
	int capacity;
	Map<Integer, ListNode> map;
	ListNode head;
	ListNode tail;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = new ListNode(-1, -1);
		tail = new ListNode(-1, -1);
		head.next = tail;
		tail.prev = head;
	}
	
	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		
		ListNode node = map.get(key);
		remove(node);
		add(node);
		return node.val;
	}
	
	public void put(int key, int value) {
		if (map.containsKey(key)) {
			ListNode oldNode = map.get(key);
			remove(oldNode);
		}
		ListNode node = new ListNode(key, value);
		map.put(key, node);
		add(node);
		
		if (map.size() > capacity) {
			ListNode nodeDelete = head.next;
			remove(nodeDelete);
			map.remove(nodeDelete.key);
		}
	}
	
	public void add(ListNode node) {
		ListNode prevEnd = tail.prev;
		prevEnd.next = node;
		node.prev = prevEnd;
		node.next = tail;
		tail.prev = node;
	}
	
	public void remove(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

}
