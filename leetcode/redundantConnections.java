class Solution {
    static class UnionFind{
        private int[] parent;
        private int[] rank;
        public UnionFind(int size){
            parent = new int[size+1];
            rank = new int[size+1];
            for(int node = 1 ; node <= size; node++){
                parent[node] = node;
                rank[node] = 1;
            }
        }
        public int find(int node){
        if(parent[node] == node)
           return node;
        parent[node] = find(parent[node]);
        return parent[node];
        }
         public boolean union(int nodeA, int nodeB){
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        if(rootA == rootB){
            return false;
        }
        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        }
        else if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        }
        else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int numberOfNodes = edges.length;
        UnionFind uf = new UnionFind(numberOfNodes);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }
}
