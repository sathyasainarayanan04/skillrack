class Solution {
    static class DisjointUnion{
        private int[] rank;
        private int[] parent;
        public DisjointUnion(int totalNodes){
            rank = new int[totalNodes+1];
            parent = new int[totalNodes+1];
            for(int node=1; node<=totalNodes; node++){
                rank[node] = 1;
                parent[node] = node;
            }
        }
        public int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            parent[node] = findParent(parent[node]);
            return parent[node];
        }
        public void Union(int nodeA, int nodeB){
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            if(parentA!=parentB){
                if(rank[parentA] == rank[parentB]){
                    rank[parentA]++;
                    parent[parentB] = parentA;
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
    public List<Boolean> areConnected(int totalNodes, int threshold, int[][] queries) {
        DisjointUnion DSU = new DisjointUnion(totalNodes);
        for(int node = threshold+1; node<=totalNodes; node++){
            int multiple = node + node;
            while(multiple <= totalNodes){
                DSU.Union(node, multiple);
                multiple+=node;
            }
        }
        List<Boolean> result = new ArrayList<>();
        for(int query[] : queries){
            int nodeA = query[0];
            int nodeB = query[1];
            boolean res = (DSU.findParent(nodeA) == DSU.findParent(nodeB)?true:false);
            result.add(res);
        }
        return result;
    }
}

/*n = 15  
threshold = 3  
queries = [[5,10],[9,12],[6,15],[8,12],[7,14],[4,9],[2,14]]
4, 8, 12,6
5, 10, 15
7,14
9
11
13
1
2
3*/
