class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefixSum = new long[nums.length];
        long count = 0;
        for(int index=0;index<nums.length;index++){
            count += nums[index];
            prefixSum[index] = count;
        }
        int ways = 0;
        for(int index=0;index<nums.length-1;index++){
           long prefix = prefixSum[index];
           long suffix = prefixSum[nums.length-1];
           long difference = suffix - prefix;
           if(difference <= prefix)ways++;
        }
        return ways;
    }
}
