//Question:94
//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//		 **INORDER* L N R
//
//Example 1:
//
//
//Input: root = [1,null,2,3]
//Output: [1,3,2]
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

public class BinaryTreeInorderTraversal {
	 List<Integer> list = new LinkedList<>();
	 public List<Integer> inorderTraversal(TreeNode root) {
		 helper(root);
		 return list;
	 }
	 private void helper(TreeNode root) {
		 if (root == null) return;
		 helper(root.left);
		 list.add(root.val);
		 helper(root.right);
	 }
}
