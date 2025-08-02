class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));
        for(int stone : stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size()>1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            maxHeap.add(first-second);
        }
        return maxHeap.poll();
    }
}
