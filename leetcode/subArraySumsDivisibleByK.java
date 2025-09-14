class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        int prefixSum =0;
        int numberOfSubArrays = 0;
        for(int index=0; index< nums.length; index++){
            int ans = nums[index];
            if(nums[index]<0){
               ans = (nums[index] % k) + k;
            }
            prefixSum = (prefixSum + ans) % k;
            int currentSubArrays = prefixSumMap.getOrDefault(prefixSum,0);
            numberOfSubArrays += currentSubArrays;
            prefixSumMap.put(prefixSum, currentSubArrays + 1);
        }
        return numberOfSubArrays;
    }
}
