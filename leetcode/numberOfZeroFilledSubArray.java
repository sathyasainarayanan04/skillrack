class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int right;
        long count = 0;
        for(int left=0;left<nums.length;left++){
            if(nums[left]!=0)continue;
            right = left;
            while(right<nums.length && nums[right]==0){
                count  = count + (right-left+1);
                right++;
            }
            left = right-1;
        }
        return count;
    }
}
