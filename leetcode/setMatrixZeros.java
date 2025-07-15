class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        for(int row =0 ; row<matrix.length; row++){
            for(int col=0 ; col<matrix[0].length; col++){
                if(matrix[row][col]==0){
                    queue.offer(new int[]{row,col});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] position = queue.poll();
            for(int row=position[0];row<matrix.length;row++){
                matrix[row][position[1]]=0;
            }
            for(int col=position[1];col<matrix[0].length;col++){
                matrix[position[0]][col]=0;
            }
            for(int row=position[0];row>=0;row--){
                matrix[row][position[1]]=0;
            }
            for(int col=position[1];col>=0;col--){
                matrix[position[0]][col]=0;
            }
        }
    }
}
