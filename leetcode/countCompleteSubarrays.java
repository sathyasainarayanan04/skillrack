class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int length = nums.length;
        Set<Integer> uniqueSet = new HashSet<>();
        for(int num : nums){
            uniqueSet.add(num);
        }
        int totalDistinct = uniqueSet.size();
        int right = 0;
        int result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int left =0;left<length; left++){
           if(left>0){
            int toRemove = nums[left-1];
            freqMap.put(toRemove, freqMap.get(toRemove)-1);
            if(freqMap.get(toRemove)==0)freqMap.remove(toRemove);
           }
           while(right < length && freqMap.size()<totalDistinct){
            freqMap.put(nums[right],freqMap.getOrDefault(nums[right],0)+1);
            right++;
           }
           if(freqMap.size()==totalDistinct){
            result += (length-(right-1));
           }
        }
        return result;
    }
}
