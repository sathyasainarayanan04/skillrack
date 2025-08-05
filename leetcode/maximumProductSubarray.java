class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int maximum = Integer.MIN_VALUE;
        for(int index=0;index<nums.length;index++){
            prefix = prefix*nums[index];
            suffix = suffix*nums[nums.length-1-index];
            maximum = Math.max(maximum,prefix);
            maximum = Math.max(maximum,suffix);
            prefix =  prefix==0?1:prefix;
            suffix = suffix==0?1:suffix;
        }
        return maximum;
    }
}
