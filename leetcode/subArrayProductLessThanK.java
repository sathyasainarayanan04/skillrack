class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int product = 1;
        int totalSubArrays = 0;
        if(k<=1)return 0;
        for(int right = 0;right<nums.length; right++){
            product = product * nums[right];
            if(product<k){
                totalSubArrays +=  (right - left + 1);
            }
            else{
                while(product>=k && left<nums.length){
                    product = product/nums[left];
                    left++;
                }
                if(right-left+1>0 && product>1){
                totalSubArrays +=  (right - left + 1);
                }
            }
        }
        return totalSubArrays;
    }
}
