class Solution {
    static class DisjointSetUnionFind{
        private int[] rank;
        private int[] parent;
        private int components;
        public DisjointSetUnionFind(int numberOfNodes){
          this.rank = new int[numberOfNodes];
          this.parent = new int[numberOfNodes];
          for(int node = 0; node < numberOfNodes; node++){
            rank[node] = 1;
            parent[node]=node;
            components++;
          }
        }
        public int findParent(int node){
            if(parent[node]==node)return node;
            parent[node] = findParent(parent[node]);
            return parent[node];
        }
        public void UnionFind(int nodeA, int nodeB){
            int rootA = findParent(nodeA);
            int rootB = findParent(nodeB);
            if(rootA!=rootB){
                components--;
                if(rank[rootA]<rank[rootB])
                  parent[rootA] = parent[rootB];
                else if(rank[rootB]<rank[rootA])
                  parent[rootB] = parent[rootA];
                else {
                  parent[rootB] = parent[rootA];
                  rank[rootA]++;
                }   
            }
        }
        public int getComponents(){
            return components;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1)return -1;
        DisjointSetUnionFind dsu = new DisjointSetUnionFind(n);
        for(int connection[] : connections){
            int nodeA = connection[0];
            int nodeB = connection[1];
            dsu.UnionFind(nodeA,nodeB);
        }
        return dsu.getComponents()-1;
    }
}
