//Question:116
//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
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
//Input: root = [1,2,3,4,5,6,7]
//Output: [1,#,2,3,#,4,5,6,7,#]
//Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
//Example 2:
//
//Input: root = []
//Output: []
		
package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
        	int size = q.size();
        	Node pre = null;
        	for (int i = 0; i < size; i++) {
        		Node node = q.poll();
        		if (pre != null) {
        			pre.next = node;
        		}
        		pre = node;
        		
        		if (node.left != null && node.right != null) {
        			q.add(node.left);
        			q.add(node.right);
        		}
        	}
        }
        return root;
    }
}
