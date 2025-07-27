class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0;
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        int maximumLength = 0;
        for(int right =0;right<nums.length;right++){
           frequencyMap.put(nums[right],frequencyMap.getOrDefault(nums[right],0)+1);
           while(frequencyMap.get(nums[right])>k){
            frequencyMap.put(nums[left],frequencyMap.get(nums[left])-1);
            if(frequencyMap.get(nums[left])==0){
                frequencyMap.remove(nums[left]);
            }
            left++;
           }
           maximumLength = Math.max(maximumLength,(right-left+1));
        }
        return maximumLength;
    }
}
