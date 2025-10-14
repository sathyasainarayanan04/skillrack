class Solution {
    static class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int totalFriends){
            parent = new int[totalFriends];
            rank = new int[totalFriends];
            for(int node = 0; node<totalFriends; node++){
                parent[node] = node;
                rank[node] = 1;
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
                if(rank[parentA] == rank[parentB]){
                    parent[parentB] = parentA;
                    rank[parentA]++;
                }
                else if(rank[parentA]< rank[parentB]){
                    parent[parentA] = parent[parentB];
                }
                else{
                    parent[parentB] = parent[parentA];
                }
            }
        }
    }
        public static boolean[] friendRequests(int numberOfFriends, int [][] restrictions, int[][] requests){
            boolean[] result = new boolean[requests.length];
            UnionFind uf = new UnionFind(numberOfFriends);
            for(int request=0; request<requests.length; request++){
                int nodeA = requests[request][0];
                int nodeB = requests[request][1];
                int parentA = uf.findParent(nodeA);
                int parentB = uf.findParent(nodeB);
                if(parentA == parentB){
                    result[request] =true;
                    continue;
                }
                boolean violates = false;
                for(int restriction[] : restrictions){
                    int restNodeA = restriction[0];
                    int restNodeB = restriction[1];
                    int parentOfRestNodeA = uf.findParent(restNodeA);
                    int parentOfRestNodeB = uf.findParent(restNodeB);
                    if((parentA==parentOfRestNodeA && parentB==parentOfRestNodeB)||
                            (parentA==parentOfRestNodeB && parentB==parentOfRestNodeA)){
                        violates = true;
                        break;
                    }
                    
                }
                if(violates){
                    result[request] = false;
                }
                else{
                    result[request] = true;
                    uf.Union(parentA, parentB);
                }
            }
            return result;
        }

    /*public static void main(String[] args){
        int numberOfFriends = 3;
        Solution solution = new Solution();
        int[][] restrictions = {{0,1}};
        int[][] requests = {{0,2},{2,1}};
        boolean[] result = solution.findFriendRequestsWithoutRestrictions(numberOfFriends, restrictions, requests);
        System.out.println(Arrays.toString(result));
    }*/
}
