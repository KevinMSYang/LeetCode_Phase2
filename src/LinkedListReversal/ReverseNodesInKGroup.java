//Question:25
//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//
//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
//
//You may not alter the values in the list's nodes, only nodes themselves may be changed.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5], k = 2
//Output: [2,1,4,3,5]
//Example 2:
//
//
//Input: head = [1,2,3,4,5], k = 3
//Output: [3,2,1,4,5]

package LinkedListReversal;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        if (k == 1) return head;
        
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        
        while (cur != null) {
        	boolean space = hasSpace(k, cur);
        	if (space) {
        		pre = reverse(pre, cur, k);
        		cur = pre.next;
        	}
        	else {
        		break;
        	}
        }
        return dummy.next;
    }
    private boolean hasSpace(int k, ListNode cur) {
    	for (int i = 1; i <= k; i++) {
    		if (cur == null) return false;
    	}
    	return true;
    }
    private ListNode reverse(ListNode pre, ListNode cur, int k) {
    	for (int i = 0; i < k -1; i++) {
    		ListNode temp = cur.next;
    		cur.next = temp.next;
    		temp.next = pre.next;
    		pre.next = temp;
    	}
    	return cur;
    }
}
