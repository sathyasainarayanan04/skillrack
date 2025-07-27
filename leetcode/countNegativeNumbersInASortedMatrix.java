class Solution {
    public int countNegatives(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int currRow = R-1;
        int currCol = 0;
        int negativeCount = 0;
        while(currRow>=0 && currCol<C){
            if(grid[currRow][currCol]<0){
                negativeCount = negativeCount+(C-currCol);
                currRow--;
            }
            else{
                currCol++;
            }
        }
        return negativeCount;
    }
}
