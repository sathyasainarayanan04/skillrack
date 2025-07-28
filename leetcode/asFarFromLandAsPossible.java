class Solution {
    final int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        if(grid.length == 0 && grid[0].length==0) return -1;
        Queue<int[]> bfsQueue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        int waterCount = 0;
        int landCount = 0;
        for(int row = 0; row < R; row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]==1){
                    bfsQueue.offer(new int[]{row,col});
                    visited[row][col] = true;
                    landCount++;
                }
                else
                waterCount++;
            }
        }
        if(waterCount == 0  || landCount==0)return -1;
        int level = 1;
        int ans = 0;
        while(!bfsQueue.isEmpty()){
           int levelSize = bfsQueue.size();
           for(int index=0; index<levelSize;index++){
           int[] currentPosition = bfsQueue.poll();
           grid[currentPosition[0]][currentPosition[1]] = level;
           ans = Math.max(level,ans);
           for(int direction=0;direction<4;direction++){
              int newRow = currentPosition[0] + directions[direction][0];
              int newCol = currentPosition[1] + directions[direction][1];
              if(newRow>=0 && newRow<R && newCol>=0 && newCol<C && !visited[newRow][newCol]){
                bfsQueue.offer(new int[]{newRow, newCol});
                visited[newRow][newCol] = true;
              }
           }
           }
           level++;
        }
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                System.out.print(grid[row][col]+" ");
            }
            System.out.println();
        }
        return ans-1;
    }
}
