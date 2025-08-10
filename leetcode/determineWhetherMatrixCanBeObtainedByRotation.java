class Solution {
    public void rotateMatrixBy90(int[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        for(int row=0;row<R-1;row++){
            for(int col=row+1;col<C;col++){
               int temp = matrix[row][col];
               matrix[row][col] = matrix[col][row];
               matrix[col][row] = temp;
            }
        }
        for(int row=0;row<R;row++){
            for(int col=0;col<C/2;col++){
                int temp = matrix[row][col];
                matrix[row][col]=matrix[row][C-col-1];
                matrix[row][C-col-1]=temp;
            }
        }
    }
    public boolean isSameMatrix(int[][] matrix, int[][] targetMatrix){
        int R=matrix.length;
        int C=matrix[0].length;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(matrix[row][col]!=targetMatrix[row][col])
                return false;
            }
        }return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int attempt = 0;attempt<4;attempt++){
            rotateMatrixBy90(mat);
            boolean flag = isSameMatrix(mat,target);
            if(flag)return true;
        }
        return false;
    }
}
