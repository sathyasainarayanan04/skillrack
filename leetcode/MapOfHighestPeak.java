class Solution {
    final int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] highestPeak(int[][] isWater) {
        int R = isWater.length;
        int C = isWater[0].length;
        boolean[][] visitedMatrix = new boolean[R][C];
        Queue<int[]> bfsQueue = new LinkedList<>();
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(isWater[row][col]==1){
                isWater[row][col]=0;
                visitedMatrix[row][col]=true;
                bfsQueue.offer(new int[]{row,col});
                }
                else{
                isWater[row][col]=-1;
                }
            }
        }
        System.out.println(Arrays.deepToString(isWater));
        int level = 0;
        while(!bfsQueue.isEmpty()){
            int levelSize = bfsQueue.size();
            for(int index=0;index<levelSize;index++){
                int[] position = bfsQueue.poll();
                int currentRow = position[0];
                int currentCol = position[1];
                for(int dir[] : directions){
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];
                    if(newRow>=0 && newRow<R && newCol >= 0 && newCol < C && !visitedMatrix[newRow][newCol]){
                        isWater[newRow][newCol] = level+1;
                        visitedMatrix[newRow][newCol] = true;
                        bfsQueue.offer(new int[]{newRow,newCol});
                    }
                }
            }
            level++;
        }
        return isWater;
    }
}
