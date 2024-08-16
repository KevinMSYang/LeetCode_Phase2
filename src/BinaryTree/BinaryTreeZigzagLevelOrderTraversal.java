//Question:103
//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
//
//		 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[20,9],[15,7]]
//Example 2:
//
//Input: root = [1]
//Output: [[1]]
//Example 3:
//
//Input: root = []
//Output: []

package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        boolean leftToRight = true;
        while (!q.isEmpty()) {
        	int size = q.size();
        	List<Integer> sublist = new LinkedList<>();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = q.poll();
        		if (leftToRight) {
        			sublist.add(node.val);
        		}
        		else {
        			sublist.add(0, node.val);
        		}
        		if (node.left != null) {
        			q.add(node.left);
        		}
        		if (node.right !=i null) {
        			q.add(node.right);
        		}
        	}
        	leftToRight = !leftToRight;
        	list.add(sublist);
        }
        return list;
    }
}
