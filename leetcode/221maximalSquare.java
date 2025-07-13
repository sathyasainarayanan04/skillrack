class Solution {
    public int maximalSquare(char[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] dp = new int[R+1][C+1];
        int max = 0;
        for(int row=1;row<R+1;row++){
            for(int col=1;col<C+1;col++){
                if(matrix[row-1][col-1]=='1'){
                    int left = dp[row][col-1];
                    int up = dp[row-1][col];
                    int diagonalLeft = dp[row-1][col-1];
                    dp[row][col] = 1+(Math.min(Math.min(left,up),diagonalLeft));
                    max = Math.max(dp[row][col],max);
                }
            }
        }
        return max*max;
    }
}
