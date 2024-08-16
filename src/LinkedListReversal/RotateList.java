//Question:61
//Given the head of a linked list, rotate the list to the right by k places.
//
//
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//Example 2:
//
//
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]

package LinkedListReversal;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) return head;
		if (k == 0) return head;
		
		ListNode pre = null;
		ListNode cur = head;
		int size = 0;
		
		while (cur != null) {
			pre = cur;
			cur = cur.next;
			size++;
		}
		cur = head;
		pre.next = cur;
		
		int rotate = k % size;
		for (int i = 0; i < size - rotate; i++) {
			pre = cur;
			cur = cur.next;
		}
		pre.next = null;
		return cur;
	}
}
