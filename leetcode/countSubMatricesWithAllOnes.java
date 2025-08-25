class Solution {
    public int numSubmat(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        for(int row =0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]!=0 && row>0){
                    grid[row][col] = grid[row][col] + grid[row-1][col];
                }
            }
        }
        int totalSubMatrices = 0;
        for(int row =0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col]!=0){
                    int minHeight = grid[row][col];
                    for(int index=col; index>=0;index--){
                        if(grid[row][index]==0)break;
                        else{
                            minHeight = Math.min(minHeight, grid[row][index]);
                            totalSubMatrices = totalSubMatrices + minHeight;
                        }
                    }
                }
            }
        }
        return totalSubMatrices;
    }
}
