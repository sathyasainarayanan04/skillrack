class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (a,b)->Integer.compare(frequencyMap.get(b), frequencyMap.get(a))
        );
       
        maxHeap.addAll(frequencyMap.keySet());
        int[] result = new int[k];
        for(int index =0;index<k;index++){
            result[index] = maxHeap.poll();
        }
        return result;
    }
}
