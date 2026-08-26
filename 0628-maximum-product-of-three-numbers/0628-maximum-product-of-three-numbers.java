class Solution {
    public int maximumProduct(int[] nums) {
        // 1. Sort the numbers from smallest to largest
        Arrays.sort(nums);
        
        int n = nums.length;
        
        // 2. Case A: The 3 biggest numbers
        int caseA = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
        // 3. Case B: Two negative numbers (which become positive when multiplied) x the biggest number
        int caseB = nums[0] * nums[1] * nums[n - 1];
        
        // 4. Return the larger of the two
        return Math.max(caseA, caseB);
    }
}