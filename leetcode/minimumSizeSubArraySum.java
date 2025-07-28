class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minimumLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int right=0;right<nums.length; right++){
            sum = sum+nums[right];
            if(sum>=target)
               minimumLength = Math.min(minimumLength, (right-left+1));
            while(sum>=target){
                sum = sum - nums[left];
                minimumLength = Math.min(minimumLength,(right-left+1));
                left++;
            }
        }
        return minimumLength==Integer.MAX_VALUE?0:minimumLength;
    }
}
