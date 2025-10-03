class Solution {
    public int[] maxSlidingWindow(int[] nums, int windowSize) {
        int length = nums.length;
        int[] maximumValues = new int[length - windowSize +1];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0],a[0])
        );
        int resultIndex =0;
        for(int currentIndex = 0; currentIndex < length; currentIndex++){
            maxHeap.offer(new int[]{nums[currentIndex], currentIndex});
            while(maxHeap.peek()[1] <= currentIndex-windowSize){
                maxHeap.poll();
            }
            if(currentIndex >= windowSize-1){
                maximumValues[resultIndex++] = maxHeap.peek()[0];
            }
        }
        return maximumValues;
    }
}
