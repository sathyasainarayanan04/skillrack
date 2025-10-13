class Solution {
    static class DisjointSetUnion{
        private int rank[];
        private int parent[];
        public DisjointSetUnion(int totalNodes){
            rank = new int[totalNodes];
            parent = new int[totalNodes];
            for(int node=0; node<totalNodes; node++){
                rank[node] = 1;
                parent[node] = node;
            }
        }
        public int findParent(int node){
            if(parent[node] == node)return node;
            parent[node] = findParent(parent[node]);
            return parent[node];
        }
        public void Union(int nodeA, int nodeB){
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            if(parentA!=parentB){
                if(rank[parentA]==rank[parentB]){
                    parent[parentB] = parentA;
                    rank[parentA]++; 
                }
                else if(rank[parentA]<rank[parentB]){
                    parent[parentA] = parentB;
                }
                else{
                    parent[parentB] = parentA;
                }
            }
        }
    }
    public boolean[] pathExistenceQueries(int totalNodes, int[] nums, int maxDiff, int[][] queries) {
        boolean result[] = new boolean[queries.length];
        DisjointSetUnion DSU = new DisjointSetUnion(totalNodes);
        for(int index =0; index < nums.length-1; index++){
            if(Math.abs(nums[index] - nums[index+1]) <= maxDiff){
                DSU.Union(index , index+1);
            }
        }
        for(int query=0; query < queries.length; query++){
            int nodeA = queries[query][0];
            int nodeB = queries[query][1];
            if(DSU.parent[nodeA] == DSU.parent[nodeB]){
                result[query] = true;
            }
            else{
                result[query] = false;
            }
        }
        return result;
    }
}
