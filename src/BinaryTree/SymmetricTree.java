//Question:101
//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//
//
//Example 1:
//
//
//Input: root = [1,2,2,3,4,4,3]
//Output: true
//Example 2:
//
//
//Input: root = [1,2,2,null,3,null,3]
//Output: false

package BinaryTree;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return helper(root.left, root.right);
	}
	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left != null && right != null) {
			return left.val == right.val &&
					helper(left.right, right.left) &&
					helper(left.left, right.right);
		}
		return false;
	}
}
