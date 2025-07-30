class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length, C = matrix[0].length;
        int col = C-1,row=0;
        while(row <R && col>=0){
            if(matrix[row][col]==target)return true;
            else if(target>matrix[row][col]){
                row = row+1;
            }
            else if(target<matrix[row][col]){
                col = col-1;
            }
        }
        return false;
    }
}
