class Solution {
    public int findMaxLength(int[] nums) {
        for(int index=0; index<nums.length; index++){
            if(nums[index]==0){
                nums[index] = -1;
            }
        }
        int prefixSum = nums[0];
        for(int index=1; index<nums.length; index++){
           nums[index] = nums[index] + prefixSum;
           prefixSum = nums[index];
        }
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,-1);
        int maxLength = 0;
        for(int index=0; index<nums.length; index++){
            if(prefixMap.containsKey(nums[index])){
               maxLength = Math.max(maxLength, index - prefixMap.get(nums[index]));
            }
            else{
                prefixMap.put(nums[index],index);
            }
        }
        return maxLength;
    }
}
