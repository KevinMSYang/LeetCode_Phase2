//Question:145
//Given the root of a binary tree, return the postorder traversal of its nodes' values.
//
//		 **POSTORDER** L R N
//
//Example 1:
//
//
//Input: root = [1,null,2,3]
//Output: [3,2,1]
//Example 2:
//
//Input: root = []
//Output: []
//Example 3:
//
//Input: root = [1]
//Output: [1]

package BinaryTree;

import java.util.List;

public class BinaryTreePostorderTraversal {
	List<Integer> list = new LinkedList<>();
	public List<Integer> postorderTraversal(TreeNode root) {
		helper(root);
		return list;
	}
	private void helper(TreeNode root) {
		if (root == null) return;
		helper(root.left);
		helper(root.right);
		list.add(root.val);
	}
}
