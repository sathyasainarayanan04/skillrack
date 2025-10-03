class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum =0;
        for(int num : nums){
            totalSum+=num;
        }
        int requiredSum = totalSum - x;
        int longestSubArray = -1;
        int currentSubArraySum =0;
        int left = 0;
        for(int right =0; right<nums.length; right++){
            currentSubArraySum += nums[right];
            while(currentSubArraySum > requiredSum && left <= right){
                currentSubArraySum -= nums[left++];
            }
            if(currentSubArraySum == requiredSum)
            longestSubArray = Math.max(right - left + 1, longestSubArray);
        }
        if(longestSubArray == -1)return -1;
        return nums.length - longestSubArray;
    }
}
