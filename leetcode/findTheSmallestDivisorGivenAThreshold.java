class Solution {
    public boolean isMeetingThreshold(int[] nums, int threshold, int divisor){
        int sum = 0;
        for(int num : nums){
            sum += (int) Math.ceil((double)num/divisor);
        }
        return sum<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int right = Integer.MIN_VALUE;
        for(int num : nums){
            right = Math.max(right,num);
        }
        int left = 1;
        int minimum = 0;
        while(left<=right){
            int mid = left + (right -left)/2;
            if(isMeetingThreshold(nums,threshold,mid)){
                right = mid-1;
                minimum = mid;
            }
            else{
                left = mid+1;
            }
        }
        return minimum;
    }
}
