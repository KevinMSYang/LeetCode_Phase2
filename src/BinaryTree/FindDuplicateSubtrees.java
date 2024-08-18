//Question:652
//Given the root of a binary tree, return all duplicate subtrees.
//
//For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//
//Two trees are duplicate if they have the same structure with the same node values.
//
// 
//
//Example 1:
//
//
//Input: root = [1,2,3,4,null,2,4,null,null,4]
//Output: [[2,4],[4]]
//Example 2:
//
//
//Input: root = [2,1,1]
//Output: [[1]]
//Example 3:
//
//
//Input: root = [2,2,2,3,null,3,null]
//Output: [[2,3],[3]]

package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	List<TreeNode> ans = new ArrayList<>();
    	Map<String, Integer> map = new HashMap<>();
    	
    	helper(root, ans, map);
    	return ans;
    }
    private String helper(TreeNode node, List<TreeNode> ans, Map<String, Integer> map) {
    	if (node == null) return "";
    	String left = helper(node.left, ans, map);
    	String right = helper(node.right, ans, map);
    	String str = node.val + "#" + left + "#" + right;
    	
    	if (map.merge(str, 1, Integer::sum) == 2) {
    		ans.add(node);
    	}
    	return str;
    }
}
