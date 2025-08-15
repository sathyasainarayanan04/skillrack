class Solution {
    static int directions[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    private void dfsFindBorders(int[][] grid, int row, int col, int originalColor,boolean[][]visited,List<int[]> borderCells){
        visited[row][col] = true;
        int R = grid.length;
        int C = grid[0].length;
        boolean isBorderCell = false;
        for(int[] dir : directions){
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            if(newRow>=R || newRow<0 || newCol>=C || newCol<0){
                isBorderCell = true;
            }
            else if(grid[newRow][newCol]!=originalColor){
                isBorderCell = true;
            }
            else if(!visited[newRow][newCol]){
                dfsFindBorders(grid,newRow,newCol,originalColor,visited,borderCells);
            }
        }
        if(isBorderCell){
            borderCells.add(new int[]{row,col});
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int originalColor = grid[row][col];
        List<int[]> borderCells = new ArrayList<>();
        dfsFindBorders(grid,row,col,originalColor,visited,borderCells);
        for(int[] cell : borderCells){
            int xCoordinate = cell[0];
            int yCoordinate = cell[1];
            grid[xCoordinate][yCoordinate] = color;
        }
        return grid;
    }
}
