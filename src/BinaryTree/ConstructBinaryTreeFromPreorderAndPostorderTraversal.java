//Question:889
//Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
//
//If there exist multiple answers, you can return any of them.
//
// 
//
//Example 1:
//
//
//Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
//Example 2:
//
//Input: preorder = [1], postorder = [1]
//Output: [1]

package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	int[] preOrder;
	int[] postOrder;
	int index = 0;
	Map<Integer, Integer> map = new HashMap<>();
	
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    	preOrder = preorder;
    	postOrder = postorder;
    	
    	for (int i = 0; i < postorder.length; i++) {
    		map.put(postorder[i], i);
    	}
    	
    	TreeNode root = dfs(0, postorder.length-1);
    	return root;
    }
    private TreeNode dfs(int start, int end) {
    	if (start > end) return null;
    	
    	int curVal = preOrder[index++];
    	TreeNode cur = new TreeNode(curVal);
    	
    	if (start == end) return cur;
    	
    	int mid = map.get(preOrder[index]);
    	cur.left = dfs(start, mid);
    	cur.right = dfs(mid+1, end-1);
    	return cur;
    }
}
