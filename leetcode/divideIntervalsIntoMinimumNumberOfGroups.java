class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int index=0; index < intervals.length; index++){
            while(!minHeap.isEmpty() && minHeap.peek() <= intervals[index][0]){
                minHeap.poll();
            }
            minHeap.offer(intervals[index][1]);
        }
        return minHeap.size();
    }
}
