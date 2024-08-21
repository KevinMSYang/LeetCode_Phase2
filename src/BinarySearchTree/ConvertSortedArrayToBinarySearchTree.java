//Question:108
//Given an integer array nums where the elements are sorted in ascending order, convert it to a 
//height-balanced
// binary search tree.
//
// 
//
//Example 1:
//
//
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
//Example 2:
//
//
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

package BinarySearchTree;

public class ConvertSortedArrayToBinarySearchTree {
	int[] arr;
	public TreeNode sortedArrayToBST(int[] nums) {
		arr = nums;
		return dfs(0, nums.length-1);
	}
	private TreeNode dfs(int start, int end) {
		if (start > end) return null;
		
		int mid = (start - end) / 2;
		
		TreeNode cur = new TreeNode(arr[mid]);
		cur.left = dfs(start, mid -1);
		cur.right = dfs(mid + 1, end);
		return cur;
	}
}
