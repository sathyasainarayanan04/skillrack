class Solution {
    public boolean search(int[] nums, int target) {
        int leftIndex =0;
        int rightIndex = nums.length-1;
        while(leftIndex<=rightIndex){
            int middleIndex = leftIndex + (rightIndex-leftIndex)/2;
            if(nums[middleIndex]==target)return true;
            if(nums[middleIndex]==nums[leftIndex] && nums[middleIndex]==nums[rightIndex]){
                leftIndex++;
                rightIndex--;
                continue;
            }
            if(nums[leftIndex]<=nums[middleIndex]){
               if(target>=nums[leftIndex] && target<nums[middleIndex]){
                 rightIndex = middleIndex-1;
               }
               else{
                 leftIndex = middleIndex+1;
               }
            }
            else{
                if(target>nums[middleIndex] && target<=nums[rightIndex]){
                    leftIndex = middleIndex+1;
                }
                else{
                    rightIndex = middleIndex-1;
                }
            }
        }
        return false;
    }
}
