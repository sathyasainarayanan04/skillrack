class Solution {
    public int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        int windowSize = 2*k+1;
        int[] averages = new int[length];
        Arrays.fill(averages,-1);
        if(windowSize > length){
            return averages;
        }
        long windowSum = 0;
        for(int index=0; index< windowSize; index++){
            windowSum+=nums[index];
        }
        averages[k] =(int) (windowSum/windowSize);
        for(int index=k+1; index<=length-k-1; index++){
            windowSum -= nums[index-k-1];
            windowSum += nums[index+k];
            averages[index] = (int)(windowSum/windowSize);
        }
        System.out.println(length);
        return averages;
    }
}
