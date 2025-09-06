class Solution {
    public int computeSum(int number){
        int sum = 0;
        while(number > 0){
            sum = sum + (number%10);
            number = number/10;
        }
        return sum;
    }
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for(int index=0;index<nums.length;index++){
            int sum = computeSum(nums[index]);
            if(!hashMap.containsKey(sum)){
                hashMap.put(sum, new ArrayList<>());
            }
            hashMap.get(sum).add(nums[index]);
        }
        int maxSum = Integer.MIN_VALUE;
        for(List<Integer> list : hashMap.values()){
            if(list.size()>1){
                Collections.sort(list,Collections.reverseOrder());
                maxSum = Math.max(maxSum, list.get(0)+list.get(1));
            }
        }
        return maxSum>0 ? maxSum  : -1;
    }
}
