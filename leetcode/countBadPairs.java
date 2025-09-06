class Solution {
    public long countBadPairs(int[] nums) {
        long totalPairs = (long) nums.length*(nums.length-1)/2;
        Map<Integer, Long> frequencyMap = new HashMap<>();
        for(int index =0; index<nums.length; index++){
            int key = nums[index]-index;
            frequencyMap.put(key, frequencyMap.getOrDefault(key,0L)+1);
        }
        long goodPairs = 0;
        for(long count : frequencyMap.values()){
            if(count>1){
                goodPairs = goodPairs + count*(count-1)/2;
            }
        }
        return totalPairs - goodPairs;
    }
}
