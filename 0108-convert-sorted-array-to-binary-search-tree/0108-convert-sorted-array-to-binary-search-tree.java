/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode covert(int[] nums, int left, int right) {
        // Base case: if the range bounds cross, no node exists
        if (left > right) {
            return null;
        }
        
        // Find the middle element to keep the tree height-balanced
        int mid = left + (right - left) / 2;
        
        // Create the root node with the middle element
        TreeNode root = new TreeNode(nums[mid]);
        
        // Recursively build the left and right subtrees
        root.left = covert(nums, left, mid - 1);
        root.right = covert(nums, mid + 1, right);
        
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return covert(nums, 0, nums.length - 1);
    }
}
