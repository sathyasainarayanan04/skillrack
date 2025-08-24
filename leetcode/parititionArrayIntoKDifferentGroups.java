class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int totalElements = nums.length;
        if(totalElements%k!=0)return false;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
            int frequency = frequencyMap.get(num);
            if(frequency> totalElements/k){
                return false;
            }
        }
        return true;
    }
}
