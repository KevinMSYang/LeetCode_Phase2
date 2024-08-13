//Question:328
//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//
//The first node is considered odd, and the second node is even, and so on.
//
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
//
//You must solve the problem in O(1) extra space complexity and O(n) time complexity.

package LinkedList;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode curOdd = oddList;
        ListNode curEven = evenList;
        
        while (curOdd.next != null && curEven.next != null) {
        	curOdd.next = curEven.next;
        	curOdd = curOdd.next;
        	
        	curEven.next = curOdd.next;
        	curEven = curEven.next;
        }
        curOdd.next = evenList;
        return head;
    }
}
