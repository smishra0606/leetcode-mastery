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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean LeftToRight=true;
        while(!q.isEmpty()){
            int level=q.size();
            List<Integer> currlevel=new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode curr=q.poll();
                currlevel.add(curr.val);
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(!LeftToRight){
                Collections.reverse(currlevel);
            }
            result.add(currlevel);
            LeftToRight=!LeftToRight;
        }
        return result;
    }
}