class Solution {
    public int search(int[] nums, int target) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        while(leftIndex<=rightIndex){
            int middleElement = leftIndex + (rightIndex-leftIndex)/2;
            if(nums[middleElement]==target)return middleElement;
            if(nums[leftIndex]<=nums[middleElement]){
                if(target>=nums[leftIndex] && target<nums[middleElement]){
                    rightIndex = middleElement-1;
                }
                else{
                    leftIndex = middleElement+1;
                }
            }
            else{
                if(target>nums[middleElement] && target<=nums[rightIndex]){
                    leftIndex = middleElement+1;
                }
                else{
                    rightIndex = middleElement-1;
                }
            }
        }
        return -1;
    }
}
