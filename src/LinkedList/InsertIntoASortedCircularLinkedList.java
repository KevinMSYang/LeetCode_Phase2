//Question:708
//Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value 
//insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any signle
//node in the list, and may not be necessarily the smallest value in the circular list
//
//If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion,
//the circular list should remain sorted.abstract
//
//If the list is empty (i.e. given node is null) you should create a new single circular list and return the reference to that
//single node. Otherwise, you should return the original given node

package LinkedList;

import org.w3c.dom.Node;

public class InsertIntoASortedCircularLinkedList {
	public Node insert(Node head, int insertVal) {
		Node node = new Node(insertVal);
		
		if (head == null) {
			node.next = node;
			return node;
		}
		
		Node cur = head;
		while (cur.next != head) {
			int curVal = cur.val;
			int nxtVal = cur.next.val;
			
			if (curVal <= insertVal && insertVal <= nxtVal) {
				break;
			}
			else if (curVal > nxtVal) {
				if (curVal >= insertVal && nxtVal >= insertVal) {
					break;
				}
				if (curVal <= insertVal && nxtVal <= insertVal) {
					break;
				}
			}
			cur = cur.next;
		}
		Node temp = cur.next;
		cur.next = node;
		node.next = temp;
		return head;
	}
}
