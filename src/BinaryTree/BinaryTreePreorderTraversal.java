//Question:144
//Given the root of a binary tree, return the preorder traversal of its nodes' values.
//
//		 **PREORDER**: N L R
//
//Example 1:
//
//
//Input: root = [1,null,2,3]
//Output: [1,2,3]
//Example 2:
//
//Input: root = []
//Output: []
//Example 3:
//
//Input: root = [1]
//Output: [1]

package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	List<Integer> list = new LinkedList<>();
	public List<Integer> preorderTraversal(TreeNode root) {
		helper(root);
		return list;
	}
	private void helper(TreeNode root) {
		if (root == null) return;
		list.add(root.val);
		helper(root.left);
		helper(root.right);
	}
}
