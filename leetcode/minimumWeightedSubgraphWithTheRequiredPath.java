class Solution {
    static class Edge{
        int city;
        long weight;
        Edge(int city, long weight){
            this.city = city ;
            this.weight = weight;
        }
    }
    public Map<Integer, List<Edge>> buildGraph(int[][] edges, int totalNodes){
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int index=0; index<totalNodes; index++){
           graph.put(index,new ArrayList<>());
        }
        for(int index=0; index<edges.length; index++){
            int nodeA = edges[index][0];
            int nodeB = edges[index][1];
            int weight = edges[index][2];
            graph.get(nodeA).add(new Edge(nodeB, (long) weight));
        }
        return graph;
    }
    public Map<Integer, List<Edge>> buildReversedGraph(int[][] edges, int totalNodes){
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int index=0; index<totalNodes; index++){
           graph.put(index, new ArrayList<>());
        }
        for(int index=0; index<edges.length; index++){
            int nodeA = edges[index][0];
            int nodeB = edges[index][1];
            int weight = edges[index][2];
            graph.get(nodeB).add(new Edge(nodeA, (long)weight));
        }
        return graph;
    }
    public long[] dijkstra(Map<Integer, List<Edge>> graph, int totalNodes, int source){
        long[] minimumDistance = new long[totalNodes];
        Arrays.fill(minimumDistance, Long.MAX_VALUE);
        minimumDistance[source] = 0;
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(
            (a,b) -> Long.compare(a[1],b[1])
        );
        minHeap.offer(new long[]{source, 0});
        while(!minHeap.isEmpty()){
            long[] current = minHeap.poll();
            int currentCity = (int)current[0];
            long currentDistance = current[1];
            if(currentDistance > minimumDistance[currentCity]) continue;
            for(Edge neighbor : graph.getOrDefault(currentCity, new ArrayList<>())){
                int neighborCity = neighbor.city;
                long neighborCityDistance = currentDistance + neighbor.weight;
                if(minimumDistance[neighborCity]>neighborCityDistance){
                    minimumDistance[neighborCity] = neighborCityDistance;
                    minHeap.offer(new long[]{neighborCity, neighborCityDistance});
                }
            }
        }
        return minimumDistance;
    }
    public long minimumWeight(int totalNodes, int[][] edges, int src1, int src2, int dest) {
        Map<Integer, List<Edge>> graph = buildGraph(edges, totalNodes);
        Map<Integer, List<Edge>> reversedGraph = buildReversedGraph(edges, totalNodes);
        long[] minDistanceForSource1 = dijkstra(graph, totalNodes, src1);
        long[] minDistanceForSource2 = dijkstra(graph, totalNodes, src2);
        long[] minDistanceForDestination = dijkstra(reversedGraph, totalNodes, dest);
        long minDistance = Long.MAX_VALUE;
        for(int index =0; index<totalNodes; index++){
            long minDist1 = minDistanceForSource1[index];
            long minDist2 = minDistanceForSource2[index];
            long minDistDest = minDistanceForDestination[index];
            if(minDist1 == Long.MAX_VALUE || minDist2 == Long.MAX_VALUE || minDistDest == Long.MAX_VALUE){
                continue;
            }
            minDistance = Math.min(minDistance, (minDist1 + minDist2 + minDistDest));
        }
        return minDistance == Long.MAX_VALUE ? -1 : minDistance;
    }
}
