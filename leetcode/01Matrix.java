class Solution {
    final int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int row=0; row<R; row++){
            for(int col=0;col<C;col++){
                if(mat[row][col]==0){
                    visited[row][col] = true;
                    bfsQueue.offer(new int[]{row,col});
                }
            }
        }
        int resultMatrix[][] = new int[R][C];
        while(!bfsQueue.isEmpty()){
            int levelSize = bfsQueue.size();
            for(int index=0;index<levelSize;index++){
                int[] currentPosition = bfsQueue.poll();
                for(int dir[] : directions){
                    int newRow = currentPosition[0] + dir[0];
                    int newColumn = currentPosition[1] + dir[1];
                    if(newRow>=0 && newRow<R && newColumn>=0 && newColumn<C){
                        if(!visited[newRow][newColumn]){
                            resultMatrix[newRow][newColumn] = resultMatrix[currentPosition[0]][currentPosition[1]] + 1;
                            visited[newRow][newColumn] = true;
                            bfsQueue.offer(new int[]{newRow,newColumn});
                        }
                    }
                }
            }
        }
        return resultMatrix;
    }
}
