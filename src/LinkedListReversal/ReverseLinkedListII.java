//Question:92
//Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//
//		 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//Example 2:
//
//Input: head = [5], left = 1, right = 1
//Output: [5]

package LinkedListReversal;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null) return head;
		if (left == right) return head;
		
		ListNode dummy = new ListNode(0, head);
		ListNode pre = dummy;
		
		for (int i = 0; i < left -1; i++) {
			pre = pre.next;
		}
		ListNode cur = pre.next;
		
		for (int i = 0; i < right - left; i++) {
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		return dummy.next;
	}
}
