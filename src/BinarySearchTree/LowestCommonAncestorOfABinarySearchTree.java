//Question:235
//Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
//
// 
//
//Example 1:
//
//
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
//Example 2:
//
//
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//Example 3:
//
//Input: root = [2,1], p = 2, q = 1
//Output: 2

package BinarySearchTree;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        
        while (root != null) {
        	int cur = root.val;
        	if (min < cur && max < cur) {
        		root = root.left;
        	}
        	else if (min > cur && max > cur) {
        		root = root.right;
        	}
        	else {
        		break;
        	}
        }
        return root;
    }
}
