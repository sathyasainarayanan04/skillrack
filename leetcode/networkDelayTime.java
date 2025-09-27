class Solution {
    public int networkDelayTime(int[][] times, int numberOfNodes, int startNode) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
          int source = time[0];
          int destination = time[1];
          int weight = time[2];
          if(!graph.containsKey(source)){
            graph.put(source, new ArrayList<>());
          }
          graph.get(source).add(new int[]{destination, weight});
        }
        int[] minTimeToReach = new int[numberOfNodes+1];
        Arrays.fill(minTimeToReach, Integer.MAX_VALUE);
        minTimeToReach[startNode] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );
        pq.add(new int[]{startNode, 0});
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            if(currentDistance > minTimeToReach[currentNode])continue;
            if(graph.containsKey(currentNode)){
                for(int[] neighbor : graph.get(currentNode)){
                    int neighborNode = neighbor[0];
                    int travelTime = neighbor[1];
                    int newDistance = currentDistance + travelTime;
                    if(newDistance < minTimeToReach[neighborNode]){
                        minTimeToReach[neighborNode] = newDistance;
                        pq.add(new int[]{neighborNode, newDistance});
                    }
                }
            }
        }
        int maxTime = 0;
        for(int index=1; index <=numberOfNodes ; index++){
            if(minTimeToReach[index] == Integer.MAX_VALUE) 
            return -1;
            maxTime = Math.max(maxTime, minTimeToReach[index]);
        }
        return maxTime;
    }
}
