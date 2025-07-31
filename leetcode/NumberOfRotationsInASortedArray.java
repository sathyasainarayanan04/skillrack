class Solution {
    public int findMin(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int minimum = Integer.MAX_VALUE;
        int counter = 0;
        while(leftIndex<=rightIndex){
            int middleIndex = leftIndex + (rightIndex -leftIndex)/2;
            if(nums[leftIndex]<=nums[middleIndex]){
               minimum = Math.min(minimum,nums[leftIndex]);
               leftIndex = middleIndex+1;
            }
            else if(nums[rightIndex]>=nums[middleIndex]){
               minimum = Math.min(minimum,nums[middleIndex]);
               rightIndex = middleIndex-1;
            }
            counter++;
        }
        System.out.println(counter);
        return minimum;
    }
}
