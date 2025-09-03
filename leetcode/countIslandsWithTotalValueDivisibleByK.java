class Solution {
    public int bfsSum(int[][] grid, boolean[][] visited, int r, int c){
        int R = grid.length;
        int C = grid[0].length;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Integer> cellsQueue = new LinkedList<>(); 
        cellsQueue.offer(r*C+c);
        visited[r][c] = true;
        int sum = 0;
        while(!cellsQueue.isEmpty()){
            int queueSize = cellsQueue.size();
            for(int index=0;index<queueSize;index++){
            int element = cellsQueue.poll();
            int row = element/C;
            int col = element%C;
            sum += grid[row][col];
            for(int[] dir : directions){
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if(newRow<R && newRow>-1 && newCol <C && newCol > -1 && !visited[newRow][newCol] && grid[newRow][newCol]!=0){
                  visited[newRow][newCol] = true;
                  cellsQueue.offer(newRow*C+newCol);
                }
            }
            }
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int islandCount =0;
        for(int row =0;row<R;row++){
            for(int col=0;col<C;col++){
               if(grid[row][col]!=0){
               int islandSum = bfsSum(grid,visited,row,col);
               if(islandSum%k==0){
                islandCount++;
               }
               }
               
            }
        }
        return islandCount;
    }
}
