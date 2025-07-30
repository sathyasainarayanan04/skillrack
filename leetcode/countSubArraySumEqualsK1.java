class Solution {
    public int subarraySum(int[] nums, int target) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0,1);
        for(int index=0;index<nums.length;index++){
            prefixSum = prefixSum + nums[index];
            count += frequencyMap.getOrDefault(prefixSum-target,0);
            frequencyMap.put(prefixSum,frequencyMap.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
