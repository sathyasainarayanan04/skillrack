class Solution {
    private static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int index =0; index< n; index++){
            graph.put(index, new ArrayList<>());
        }
        for(int[] road : roads){
            int from = road[0];
            int to = road[1];
            int time = road[2];
            graph.get(from).add(new int[]{to, time});
            graph.get(to).add(new int[]{from, time});
        }
        long[] shortestTime = new long[n];
        Arrays.fill(shortestTime, Long.MAX_VALUE);
        int[] ways = new int[n];
        ways[0]= 1;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(
            (a,b) -> Long.compare(a[1],b[1])
        );
        shortestTime[0] = 0;
        minHeap.offer(new long[]{0,0});
        while(!minHeap.isEmpty()){
            long[] current = minHeap.poll();
            int currentNode = (int) current[0];
            long currentTime = current[1];
            if(currentTime > shortestTime[currentNode]) continue;
                for(int[] neighbor : graph.get(currentNode)){
                    int nextNode = (int) neighbor[0];
                    long nextNodeTime = neighbor[1];
                    long newTime = currentTime + nextNodeTime;
                    if(newTime < shortestTime[nextNode]){
                        shortestTime[nextNode] = newTime;
                        ways[nextNode] = ways[currentNode];
                        minHeap.offer(new long[]{nextNode, newTime});
                    }
                    else if(newTime == shortestTime[nextNode]){
                        ways[nextNode] = (int)((ways[nextNode] + ways[currentNode]) % MOD);
                    }
                }
        }
        return ways[n-1];
    }
}
