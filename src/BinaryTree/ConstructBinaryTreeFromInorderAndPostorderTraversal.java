//Question:106
//Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
//
//		 
//
//Example 1:
//
//
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
//Example 2:
//
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]

package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	int[] inOrder;
	int[] postOrder;
	Map<Integer, Integer> map = new HashMap<>();
	int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        index = inorder.length -1;
        
        for (int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        
        TreeNode root = dfs(0, inorder.length-1);
        return root;
    }
    private TreeNode dfs(int start, int end) {
    	if (start > end) return null;
    	
    	int curVal = postOrder[index--];
    	TreeNode cur = new TreeNode(curVal);
    	
    	int mid = map.get(curVal);
    	cur.right = dfs(mid+1, end);
    	cur.left = dfs(start, mid-1);
    	return cur;
    }
}
