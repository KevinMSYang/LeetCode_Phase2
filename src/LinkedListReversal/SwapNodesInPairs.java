//Question:24
//Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
//
//		 
//
//Example 1:
//
//
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
//Example 2:
//
//Input: head = []
//Output: []
//Example 3:
//
//Input: head = [1]
//Output: [1]

package LinkedListReversal;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        
        while (cur != null && cur.next != null) {
        	ListNode nex = cur.next;
        	cur.next = nex.next;
        	nex.next = pre.next;
        	pre.next = nex;
        	
        	pre = cur;
        	cur = cur.next;
        }
        return dummy.next;
    }
}
