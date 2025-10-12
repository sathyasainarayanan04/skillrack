class Solution {
    final int directions[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    static class PathFormat{
        int row;
        int column;
        int maxKey;
        public PathFormat(int row, int column, int maxKey){
            this.row = row;
            this.column = column;
            this.maxKey = maxKey;
        }
    }
    public int swimInWater(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        PriorityQueue<PathFormat> minHeap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.maxKey, b.maxKey)
        );
        minHeap.offer(new PathFormat(0,0,grid[0][0]));
        int[][] maxKeySoFar = new int[R][C];
        for(int row[] : maxKeySoFar){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        maxKeySoFar[0][0] = grid[0][0];
        while(!minHeap.isEmpty()){
            PathFormat currentObject = minHeap.poll();
            int currentRow = currentObject.row;
            int currentColumn = currentObject.column;
            int maxKey = currentObject.maxKey;
            if(currentRow == R-1 && currentColumn == C-1)return maxKey;
            for(int direction[] : directions){
                int newRow = currentRow + direction[0];
                int newColumn = currentColumn + direction[1];
                if(newRow>=0 && newColumn>=0 && newRow < R && newColumn < C){
                    int nextMaxKey = grid[newRow][newColumn];
                    int newKey = Math.max(nextMaxKey, maxKey);
                    if(newKey < maxKeySoFar[newRow][newColumn]){
                        maxKeySoFar[newRow][newColumn] = newKey;
                        minHeap.offer(new PathFormat(newRow, newColumn, newKey));
                    }
                }
            }
        }
        return -1;
    }
}
