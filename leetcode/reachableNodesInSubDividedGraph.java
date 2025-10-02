class Solution {
    public Map<Integer, List<int[]>> buildGraph(int[][] edges, int numberOfNodes){
       Map<Integer, List<int[]>> graph = new HashMap<>();
       for(int node =0; node < numberOfNodes; node++){
        graph.put(node, new ArrayList<>());
       }
       for(int edge[] : edges){
        int nodeA = edge[0];
        int nodeB = edge[1];
        int subDividedNodes = edge[2];
        graph.get(nodeA).add(new int[]{nodeB, subDividedNodes+1});
        graph.get(nodeB).add(new int[]{nodeA, subDividedNodes+1});
       }
       return graph;
    }
    public int[] dijikstraAlgorithm(Map<Integer, List<int[]>> graph , int numberOfNodes){
        int[] minDistance = new int[numberOfNodes];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        int startNode = 0;
        minDistance[startNode] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );
        minHeap.offer(new int[]{startNode, minDistance[startNode]});
        while(!minHeap.isEmpty()){
            int current[] = minHeap.poll();
            int currentNode = current[0];
            int currentDistance = current[1];
            if(currentDistance > minDistance[currentNode]) continue;
            for(int neighbor[] : graph.get(currentNode)){
                int neighborNode = neighbor[0];
                int neighborDistance = neighbor[1];
                int totalDistanceToReachNeighbor = neighborDistance + currentDistance;
                if(totalDistanceToReachNeighbor < minDistance[neighborNode]){
                    minDistance[neighborNode] = totalDistanceToReachNeighbor;
                    minHeap.offer(new int[]{neighborNode, totalDistanceToReachNeighbor});
                }
            }
        }
        return minDistance;
    }

    public int reachableNodes(int[][] edges, int maxMoves, int numberOfNodes) {
        if(edges.length == 0) return 1;
        Map<Integer, List<int[]>> graph = buildGraph(edges, numberOfNodes);
        int[] minDistance = dijikstraAlgorithm(graph, numberOfNodes);
        int reachableNodes = 0;
        for(int node = 0; node < numberOfNodes; node++){
            if(minDistance[node] <= maxMoves){
                reachableNodes++;
            }
        }
        for(int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            int subNodes = edge[2];
            int movesFromA = maxMoves - minDistance[nodeA] > 0 ? maxMoves - minDistance[nodeA] : 0;
            int movesFromB = maxMoves - minDistance[nodeB] > 0 ? maxMoves - minDistance[nodeB] : 0;
            reachableNodes += Math.min(subNodes, (movesFromA + movesFromB));
        }
        return reachableNodes;
    }
}
