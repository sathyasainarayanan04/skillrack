class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefixSum = 0,count=0;
        Map<Integer,Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,1);
        for(int right =0;right<nums.length;right++){
           prefixSum = prefixSum+nums[right];
           int toBeChecked = prefixSum-goal;
           count+=prefixMap.getOrDefault(toBeChecked,0);
           prefixMap.put(prefixSum,prefixMap.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
