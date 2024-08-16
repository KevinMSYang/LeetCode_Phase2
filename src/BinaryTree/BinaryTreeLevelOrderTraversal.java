//Question:102
//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//
//		 **LEVEL ORDER** BFS
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
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

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new LinkedList<>();
		if (root == null) return list;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> sublist = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				sublist.add(node.val);
				
				if (node.left != null) {
					q.add(node.left);
				}
				
				if (node.right != null) {
					q.add(node.right);
				}
			}
			list.add(sublist);
		}
		return list;
	}
}
