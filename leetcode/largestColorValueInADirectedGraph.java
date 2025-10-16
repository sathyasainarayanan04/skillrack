class Solution {
    public List<List<Integer>> buildGraph(int[] indegree, int[][] edges, int nodes){
        List<List<Integer>> graph = new ArrayList<>();
        for(int node = 0; node < nodes; node++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int nodeA = edge[0];
            int nodeB = edge[1];
            graph.get(nodeA).add(nodeB);
            indegree[nodeB]++;
        }
        return graph;
    }
    public int largestPathValue(String colors, int[][] edges) {
        int numNodes = colors.length();
        int[][] dp = new int[numNodes][26];
        int[] indegree = new int[numNodes];
        List<List<Integer>> graph = buildGraph(indegree, edges, numNodes);
        for(int index =0; index<numNodes; index++){
            int color = colors.charAt(index) - 'a';
            dp[index][color]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int node = 0; node < numNodes; node++){
            if(indegree[node] == 0){
                queue.offer(node);
            }
        }
        int processedNodes = 0;
        int maxColorValue = 0;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            processedNodes++;
            for(int color =0; color < 26; color++){
                maxColorValue = Math.max(maxColorValue, dp[currentNode][color]);
            }
            for(int neighbor : graph.get(currentNode)){
                for(int color =0; color < 26; color++){
                    int additional = (color==colors.charAt(neighbor)-'a'?1:0);
                    int parent = dp[currentNode][color];
                    int child = dp[neighbor][color];
                    dp[neighbor][color] = Math.max(child, parent+additional);
                }
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
         if(processedNodes != numNodes){
                return -1;
            }
            return maxColorValue;
    }
}
