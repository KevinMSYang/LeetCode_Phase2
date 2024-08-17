//Question:105
//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
//
//		 
//
//Example 1:
//
//
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
//Example 2:
//
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]

package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	int[] preOrder;
	int[] inOrder;
	int index = 0;
	Map<Integer, Integer> map = new HashMap<>();
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrder = preorder;
        inOrder = inorder;
        
        for (int i = 0; i < preorder.length; i++) {
        	map.put(inorder[i], i);
        }
        
        TreeNode root = dfs(0, preorder.length -1);
        return root;
    }
    private TreeNode dfs(int start, int end) {
    	if (start > end) return null;
    	
    	int curVal = preOrder[index++];
    	TreeNode cur = new TreeNode(curVal);
    	
    	int mid = map.get(curVal);
    	cur.left = dfs(start, mid -1);
    	cur.right = dfs(mid +1, end);
    	return cur;
    }
}
