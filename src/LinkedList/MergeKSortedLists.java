//Question:23
//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.
//
// 
//
//Example 1:
//
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
//Example 2:
//
//Input: lists = []
//Output: []
//Example 3:
//
//Input: lists = [[]]
//Output: []

package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		List<Integer> list = new ArrayList<>();
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		for (ListNode node : lists) {
			while (node != null) {
				list.add(node.val);
				node = node.next;
			}
		}
		
		Collections.sort(list);
		
		for (int i : list) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}
		return dummy.next;
	}
	
//	public ListNode mergeKLists(ListNode[] lists) {
//		
//		Queue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
//		
//		for (ListNode node : lists) {
//			if (node == null) continue;
//			minHeap.add(node);
//		}
//		
//		ListNode dummy = new ListNode(0);
//		ListNode cur = dummy;
//		
//		while (!minHeap.isEmpty()) {
//			ListNode top = minHeap.poll();
//			cur.next = top;
//			cur = cur.next;
//			if (top.next != null) {
//				minHeap.add(top.next);
//			}
//		}
//		return dummy.next;
//	}
}
