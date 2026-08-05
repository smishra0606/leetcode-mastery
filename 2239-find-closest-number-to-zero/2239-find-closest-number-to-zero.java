class Solution {
    public int findClosestNumber(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
           
            if(Math.abs(nums[i]) < Math.abs(ans)){
                ans=nums[i];
            }
            else if(Math.abs(nums[i])==Math.abs(ans)){
                ans=Math.max(nums[i],ans);
            }

        }
        return ans;
    }
}