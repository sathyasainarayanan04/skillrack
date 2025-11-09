class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] directions = {
            {-1,0},//up
            {1,0},//down
            {0,-1},//left
            {0,1}//right
        };
        int[][] inDegree = new int[R][C];
        for(int row = 0; row < R; row++){
            for(int column=0; column<C;column++){
                for(int direction[] : directions){
                    int newRow = row + direction[0];
                    int newCol = column + direction[1];
                    if(newRow>=R || newCol >= C || newRow <0 || newCol <0)continue;
                    if(matrix[newRow][newCol]>matrix[row][column]){
                        inDegree[newRow][newCol]++;
                    }
                }
            }
        }
        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int row =0; row < R; row++){
            for(int col =0; col  < C; col++){
                if(inDegree[row][col]==0)
                bfsQueue.offer(new int[]{row,col});
            }
        }
        int longestPath = 0;
        while(!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            longestPath++;
            for(int index = 0; index < size; index++){
                int[] currentCell = bfsQueue.poll();
                int currentRow = currentCell[0];
                int currentCol = currentCell[1];
                for(int direction[] : directions){
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];
                    if(newRow >= R || newCol >= C || newCol <0 || newRow <0)continue;
                    if(matrix[newRow][newCol] > matrix[currentRow][currentCol]){
                        inDegree[newRow][newCol]--;
                        if(inDegree[newRow][newCol]==0){
                            bfsQueue.offer(new int[]{newRow,newCol});
                        }
                    }
                }
            }
        }
        return longestPath;
    }
}
