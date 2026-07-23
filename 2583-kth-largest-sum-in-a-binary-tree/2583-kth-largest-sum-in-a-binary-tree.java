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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<Long> sum=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            long currsum=0;
            for(int i=0;i<size;i++){            
                TreeNode curr=q.poll();
                currsum+=curr.val;                
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            sum.add(currsum);
        }
        if(sum.size()<k){
            return -1;
        }
        Collections.sort(sum);
        return sum.get(sum.size()-k);
    }
}