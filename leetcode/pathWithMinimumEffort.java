class Solution {
    static class Cell{
        int row, effort, column;
        public Cell(int effort, int row, int column){
            this.row = row;
            this.column = column;
            this.effort = effort;
        }
    }
    private static  int[][] DIRECTIONS = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int minimumEffortPath(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;
        int[][] minEffort = new int[R][C];
        for(int[] rows : minEffort){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;
        boolean[][] visited = new boolean[R][C];
        PriorityQueue<Cell> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a.effort, b.effort)
        );
        pq.offer(new Cell(0,0,0));
        while(!pq.isEmpty()){
            Cell current = pq.poll();
            int currentEffort = current.effort;
            int currentRow = current.row;
            int currentColumn = current.column;
            if(currentRow == R-1 && currentColumn == C-1){
                return currentEffort;
            }
            if(visited[currentRow][currentColumn])continue;
            visited[currentRow][currentColumn] = true;
            for(int dir[] : DIRECTIONS){
                int newRow = currentRow + dir[0];
                int newColumn = currentColumn + dir[1];
             if(newRow >=0 && newRow < R && newColumn >=0 && newColumn < C){
                int stepEffort = Math.abs(heights[newRow][newColumn]-heights[currentRow][currentColumn]);
                int newEffort = Math.max(stepEffort, currentEffort);
                if(newEffort < minEffort[newRow][newColumn]){
                    minEffort[newRow][newColumn] = newEffort;
                    pq.offer(new Cell(newEffort, newRow, newColumn));
                }
                }
            }
        }
        return 0;
    }
}
