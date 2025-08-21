class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max_straight_sum = Integer.MIN_VALUE;
        int temp_max_sum = 0;
        int min_straight_sum = Integer.MAX_VALUE;
        int temp_min_sum = 0;
        int array_sum = 0;
        for(int index=0;index<nums.length;index++){
            temp_max_sum = nums[index] + temp_max_sum;
            if(temp_max_sum < 0){
                temp_max_sum = 0;
            }
            max_straight_sum = Math.max(temp_max_sum, max_straight_sum);
            array_sum = array_sum + nums[index];
            temp_min_sum = nums[index] + temp_min_sum;
            if(temp_min_sum > 0){
                temp_min_sum = 0;
            }
            min_straight_sum = Math.min(temp_min_sum, min_straight_sum);
        }
        System.out.println("max_straight_sum: " +max_straight_sum);
        System.out.println("min_straight_sum: "+ min_straight_sum);
        if(min_straight_sum<0 && max_straight_sum==0){
            int min_value = Integer.MIN_VALUE;
            for(int index=0;index<nums.length;index++){
               min_value = Math.max(min_value, nums[index]);
            }
            return min_value;
        }
        return Math.max(max_straight_sum, array_sum-min_straight_sum);
    }
}
