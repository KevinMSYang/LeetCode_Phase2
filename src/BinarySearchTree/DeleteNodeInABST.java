//Question:450
//Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//
//Basically, the deletion can be divided into two stages:
//
//Search for a node to remove.
//If the node is found, delete the node.
// 
//
//Example 1:
//
//
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
//
//Example 2:
//
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
//Example 3:
//
//Input: root = [], key = 0
//Output: []

package BinarySearchTree;

public class DeleteNodeInABST {
public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root == key) {
        	if (root.left == null && root.right == null) return null;
        	
        	if (root.left != null && root.right == null) return root.left;
        	if (root.left == null && root.right != null) return root.right;
        	
        	TreeNode node = helper(root.right, root);
        	root.val = node.val;
        }
        else if (root.val < key) {
        	root.right = deleteNode(root.right, key);
        }
        else {
        	root.left = deleteNode(root.left, key);
        }
    }
	private TreeNode helper(TreeNode root, TreeNode parent) {
        TreeNode pre = parent;
        TreeNode cur = root;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }
        deleteNode(pre, cur.val);
        return cur;
	}
}
