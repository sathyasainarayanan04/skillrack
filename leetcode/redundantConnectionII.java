class Solution {
    static class UnionFind{
        private int[] parent;
        private int[] rank;
        UnionFind(int totalNodes){
            parent = new int[totalNodes+1];
            rank = new int[totalNodes+1];
            for(int node=1; node<=totalNodes; node++){
                parent[node] = node;
                rank[node] = 1;
            }
        }
        public int findParent(int node){
            if(parent[node] == node)return node;
            parent[node] = findParent(parent[node]);
            return parent[node];
        }
        public boolean Union(int nodeA, int nodeB){
            int parentOfA = findParent(nodeA);
            int parentOfB = findParent(nodeB);
            if(parentOfA!=parentOfB){
                if(rank[parentOfA] == rank[parentOfB]){
                    parent[parentOfB] = parentOfA;
                    rank[parentOfA]++;
                }
                else if(rank[parentOfA]<rank[parentOfB]){
                    parent[parentOfA] = parentOfB;
                }
                else{
                    parent[parentOfB] = parentOfA;
                }
                return true;
            }
            return false;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int numberOfNodes = edges.length;
        int[] parentOf = new int[numberOfNodes+1];
        UnionFind uf = new UnionFind(numberOfNodes+1);
        for(int node = 1; node<= numberOfNodes; node++){
            parentOf[node] = 0;
        }
        int[] candidateEdge1 = null;
        int[] candidateEdge2 = null;
        int twoParentChild = -1;
        for(int[] edge : edges){
           int parentNode = edge[0];
           int childNode = edge[1];
           if(parentOf[childNode]!=0){
            twoParentChild = childNode;
            candidateEdge1 = new int[]{parentOf[childNode], childNode};
            candidateEdge2 = edge;
            break;
           }
           parentOf[childNode] = parentNode;
        }
        int cycleFormed[] = null;
        for(int[] edge : edges){
            if (candidateEdge2 != null && Arrays.equals(edge, candidateEdge2)) {
        continue;
    }
           if(!uf.Union(edge[0], edge[1])){
              cycleFormed = edge;
              break;
           }
        }
        if (candidateEdge1 == null) {
            return cycleFormed;
        } else {
            if (cycleFormed != null) {
                return candidateEdge1;
            } else {
                return candidateEdge2;
            }
        }
    }
}
