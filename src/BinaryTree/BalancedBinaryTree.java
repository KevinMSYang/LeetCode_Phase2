//Question:110
//Given a binary tree, determine if it is 
//height-balanced
//.
//
// 
//
//Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: true
//Example 2:
//
//
//Input: root = [1,2,2,3,3,null,null,4,4]
//Output: false

package BinaryTree;

public class BalancedBinaryTree {
	int UNBALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return dfs(root) != UNBALANCED;
    }
    
    private int dfs(TreeNode root) {
    	if (root.left == null && root.right == null) return 1;
    	
    	int left = 0;
    	if (root.left != null) left = dfs(root.left);
    	if (left == UNBALANCED) return UNBALANCED;
    	
    	int right = 0;
    	if (root.right != null) right = dfs(root.right);
    	if (right == UNBALANCED) return UNBALANCED;
    	
    	if (Math.abs(right-left) <= 1) return Math.max(left, right) +1;
    	return UNBALANCED;
    }
}
