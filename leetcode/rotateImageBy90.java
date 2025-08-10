class Solution {
    public void rotate(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        for(int row=0;row<(R-1);row++){
            for(int col=row+1;col<C;col++){
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
            }
        }
        for(int row =0;row<R;row++){
            int col=0;
            while(col<C/2){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][C-col-1];
                matrix[row][C-col-1]=temp;
                col++;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
