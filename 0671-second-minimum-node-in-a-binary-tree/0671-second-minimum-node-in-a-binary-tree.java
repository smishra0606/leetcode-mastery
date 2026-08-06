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
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;

        boolean isPresent = false;
    public void minimum(TreeNode root){
        if(root==null) return;
        if(root.val<min1){            
            min1=root.val;
        }
        else if(root.val<=min2 && root.val>min1){
            isPresent = true;
            min2=root.val;
        }
        minimum(root.left);
        minimum(root.right);

    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;

        minimum(root);

        if(!isPresent){
            return -1;
        }
        return min2;
    }
}