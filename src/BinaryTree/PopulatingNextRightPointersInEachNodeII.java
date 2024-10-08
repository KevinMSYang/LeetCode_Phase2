//Question:117
//Given a binary tree
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4,5,null,7]
//Output: [1,#,2,3,#,4,5,7,#]
//Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//Example 2:
//
//Input: root = []
//Output: []

package BinaryTree;

import org.w3c.dom.Node;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        Node head = root;
        
        while (head != null) {
        	Node dummy = new Node();
        	Node temp = dummy;
        	
        	while (head != null) {
        		if (head.left != null) {
        			temp.next = head.left;
        			temp = temp.next;
        		}
        		if (head.right != null) {
        			temp.next = head.right;
        			temp = temp.next;
        		}
        		head = head.next;
        	}
        	head = dummy.next;
        }
        return root;
    }
}
