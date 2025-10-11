
import java.util.*;
public class numberOfGoodPathsLeetCode {
    private static class DSU{
        private final int[] parent;
        private final int[] size;
        public DSU(int numberOfNodes){
            parent = new int[numberOfNodes];
            size = new int[numberOfNodes];
            for(int node =0; node<numberOfNodes; node++){
                parent[node] = node;
                size[node] = 1;
            }
        }
        public int find(int node){
            if(parent[node] == node)return node;
            parent[node] = find(parent[node]);
            return parent[node];
        }
        public void union(int nodeA, int nodeB){
            int parentOfA = find(nodeA);
            int parentOfB = find(nodeB);
            if(parentOfA != parentOfB){
                if(size[parentOfA] < size[parentOfB]){
                    parent[parentOfA] = parentOfB;
                    size[parentOfB]+=size[parentOfA];
                }
                else{
                    parent[parentOfB] = parentOfA;
                    size[parentOfA]+=size[parentOfB];
                }
            }
        }
    }
    public static int numberOfGoodPaths(int[] values,int[][] edges){
        int numberOfNodes = values.length;
        List<Integer>[] adjacencyList = new ArrayList[numberOfNodes];
        for(int node =0; node< numberOfNodes; node++){
            adjacencyList[node] = new ArrayList<>();
        }
        for(int edge[] : edges){
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }
        TreeMap<Integer, List<Integer>> valueToNodes = new TreeMap<>();
        for(int node =0; node<numberOfNodes; node++){
            int value = values[node];
            if(!valueToNodes.containsKey(value)){
                valueToNodes.put(value, new ArrayList<>());
            }
            valueToNodes.get(value).add(node);
        }
        DSU dsu = new DSU(numberOfNodes);
        int goodPathsCount = numberOfNodes;
        for (int value : valueToNodes.keySet()) {
        List<Integer> nodesWithSameValue = valueToNodes.get(value);

        for (int node : nodesWithSameValue) {
            for (int neighbor : adjacencyList[node]) {
                if (values[neighbor] <= values[node]) {
                    dsu.union(node, neighbor);
                }
            }
        }

        // Count Step: Count the new paths formed at this value level
        Map<Integer, Integer> componentCounts = new HashMap<>();
        for (int node : nodesWithSameValue) {
            int root = dsu.find(node);
            componentCounts.put(root, componentCounts.getOrDefault(root, 0) + 1);
        }
        
        for (int countInComponent : componentCounts.values()) {
            goodPathsCount += (countInComponent * (countInComponent - 1)) / 2;
        }
    }

    return goodPathsCount;    }
    public static void main(String[] args){
       int[] values = {1,3,2,1,3};
       int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
         int result = numberOfGoodPaths(values, edges);
       System.out.println("The number of good paths is: " + result);
    }
}
