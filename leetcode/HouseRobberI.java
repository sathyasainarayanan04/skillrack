class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        dp[0]= nums[0];
        dp[1] = Math.max(nums[1],dp[0]);
        for(int index=2;index<nums.length;index++){
            dp[index] = Math.max((dp[index-2]+nums[index]), dp[index-1]);
        }
        return dp[nums.length-1];
    }
}
