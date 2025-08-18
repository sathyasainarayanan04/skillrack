class Solution {
    public int numSquares(int n) {
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        bfsQueue.offer(0);
        visited[0] = true;
        int level = 0;
        while(!bfsQueue.isEmpty()){
            int currentLevelSize = bfsQueue.size();
            level++;
            for(int index = 0; index< currentLevelSize; index++){
                int currentSum = bfsQueue.poll();
                for(int square = 1; square*square<=n ;square++){
                    int nextSum = currentSum + square*square;
                    if(nextSum==n){
                        return level;
                    }
                    if(nextSum<n && !visited[nextSum]){
                        bfsQueue.offer(nextSum);
                        visited[nextSum] = true;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution solver = new Solution();
        System.out.println(solver.numSquares(43));
    }
}
