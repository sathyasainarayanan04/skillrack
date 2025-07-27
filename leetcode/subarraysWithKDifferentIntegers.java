class Solution {
    public int findAtMostKElements(int[] nums, int k){
        int left = 0;
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        int count = 0;
        for(int right =0;right<nums.length;right++){
            frequencyMap.put(nums[right],frequencyMap.getOrDefault(nums[right],0)+1);
            while(frequencyMap.size()>k){
                frequencyMap.put(nums[left],frequencyMap.get(nums[left])-1);
                if(frequencyMap.get(nums[left])==0){
                    frequencyMap.remove(nums[left]);
                }
                left++;
            }
            count=count+(right-left+1);
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findAtMostKElements(nums,k) - findAtMostKElements(nums,k-1);
    }
}
