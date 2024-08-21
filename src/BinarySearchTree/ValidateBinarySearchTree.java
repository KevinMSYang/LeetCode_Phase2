//Question:98
//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//
//A valid BST is defined as follows:
//
//The left 
//subtree
// of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
// 
//
//Example 1:
//
//
//Input: root = [2,1,3]
//Output: true
//Example 2:
//
//
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.

package BinarySearchTree;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return valid(null, null, root);
	}
	
	private boolean valid(Integer min, Integer max, TreeNode root) {
		if (root == null) return true;
		
		if (min != null && root.val <= min) return false;
		if (max != null && max <= root.val) return false;
		
		boolean left = valid(min, root.val, root.left);
		boolean right = valid(root.val, max, root.right);
		return left && right;
	}
}
