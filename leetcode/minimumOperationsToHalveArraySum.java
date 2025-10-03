class Solution {
    public int halveArray(int[] nums) {
        double originalSum = 0;
        for(int num : nums){
            originalSum += num;
        }
        double targetSum = originalSum / 2;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(
            (a,b)->Double.compare(b,a)
        );
        for(int num : nums){
            maxHeap.offer((double) num);
        }
        double currentSum = originalSum;
        int operationCount = 0;
        while(currentSum > targetSum){
            double largestElement = maxHeap.poll();
            double halvedValue = largestElement/2;
            currentSum -= halvedValue;
            maxHeap.offer(halvedValue);
            operationCount++;
        }
        return operationCount;
    }
}
