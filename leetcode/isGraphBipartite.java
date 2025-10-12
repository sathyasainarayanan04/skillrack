class Solution {
    public boolean bfsColoring(int[][] graph, int[] nodeColor, int currentNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNode);
        nodeColor[currentNode] = 0;
        while(!queue.isEmpty()){
            int currentPopNode = queue.poll();
            for(int neighbor : graph[currentPopNode]){
                if(nodeColor[neighbor]==-1){
                  nodeColor[neighbor] = 1-nodeColor[currentPopNode];
                  queue.offer(neighbor);
                }
                else if(nodeColor[neighbor] == nodeColor[currentPopNode]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int totalNodes = graph.length;
        int[] nodeColor = new int[totalNodes];
        Arrays.fill(nodeColor, -1);
        for(int currentNode =0; currentNode < totalNodes; currentNode++){
            if(nodeColor[currentNode]==-1){
              if(!bfsColoring(graph, nodeColor, currentNode))return false;
            }
        }
        return true;
    }
}
