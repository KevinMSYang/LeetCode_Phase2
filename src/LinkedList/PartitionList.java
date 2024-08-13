//Question:86
//Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
// 
//
//Example 1:
//
//
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
//Example 2:
//
//Input: head = [2,1], x = 2
//Output: [1,2]

package LinkedList;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) return head;
		
		ListNode dummy1 = new ListNode();
		ListNode dummy2 = new ListNode();
		ListNode low = dummy1;
		ListNode high = dummy2;
		
		ListNode cur = head;
		
		while (cur != null) {
			if (cur.val < x) {
				low.next = cur;
				low = cur;
			}
			else {
				high.next = cur;
				high = cur;
			}
			cur = cur.next;
		}
		
		low.next = dummy2.next;
		high.next = null;
		
		return dummy1.next;
	}
}
