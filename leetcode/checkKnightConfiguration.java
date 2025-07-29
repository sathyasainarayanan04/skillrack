class Solution {
    final int[][] directions = {{2,1},{2,-1},{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2}};
    public void depthFirstSearch(int[][] grid, int row, int col,int moveNumber,boolean[][] visited){
        int R = grid.length;
        int C = grid[0].length;
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow>=0 && newRow<R && newCol>=0 && newCol<C && grid[newRow][newCol]==moveNumber && !visited[newRow][newCol]){
                  visited[newRow][newCol] = true;
                  if(moveNumber == R*C-1)return;
                  depthFirstSearch(grid,newRow,newCol,moveNumber+1,visited);
            }
        }
    }
    public boolean validOrNot(boolean[][] visited){
        for(int row=0;row<visited.length; row++){
            for(int col=0;col<visited[0].length;col++){
                if(!visited[row][col])return false;
            }
        }
        return true;
    }
    public void printBoolean(boolean[][] visited){
        for(int row =0;row<visited.length;row++){
            for(int col =0;col<visited[0].length;col++){
                System.out.print(visited[row][col]+" ");
            }
            System.out.println();
        }
    }
    public boolean checkValidGrid(int[][] grid) {
        int boardSize = grid.length;
        if(grid[0][0]!=0)return false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0]=true;
        depthFirstSearch(grid,0,0,1,visited);
        printBoolean(visited);
        boolean flag = validOrNot(visited);
        return flag;
        //grid, currentRow, currentColumn, currentMoveNumber
    }

}
