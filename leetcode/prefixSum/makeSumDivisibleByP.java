class Solution {
    public int minSubarray(int[] nums, int p) {
        int prefixSum = 0;
        int sum = 0;
        for(int index = 0; index< nums.length; index++){
            sum += nums[index];
        }
        if(sum%p == 0) return 0;
        int target = sum % p;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int resultSize = nums.length;
        for(int index=0; index<nums.length; index++){
            prefixSum = prefixSum + nums[index];
            int remainder = (prefixSum % p + p ) % p;
            int targetToBeDeleted = (remainder - target + p) % p;
            if(map.containsKey(targetToBeDeleted)){
                resultSize = Math.min(resultSize, index - map.get(targetToBeDeleted));
            }
            map.put(remainder, index);
        }
        return resultSize == nums.length ? -1 : resultSize;
    }
}
