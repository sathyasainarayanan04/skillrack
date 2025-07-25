class Solution {
    final int[][] directions = {
        {-1,0},//up
        {1,0},//down
        {0,1},//right
        {0,-1},//left
        {-1,-1},//top left
        {-1,1},//top right
        {1,-1},//bottom left
        {1,1}//bottom right
    };
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        int R = board.length;
        int C = board[0].length;
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new int[]{click[0],click[1]});
        boolean[][] visited = new boolean[R][C];
        visited[click[0]][click[1]] = true;
        while(!bfsQueue.isEmpty()){
            int levelSize = bfsQueue.size();
            for(int index=0;index<levelSize;index++){
                int currentPosition[] = bfsQueue.poll();
                int row = currentPosition[0];
                int col = currentPosition[1];
                int adjMines = 0;
                List<int[]> neighbors = new ArrayList<>();
                for(int[] dir : directions){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if(newRow>=0 && newRow<R && newCol>=0 && newCol<C){
                       if(board[newRow][newCol]=='M')
                       {
                          adjMines++;
                       }
                    else if(board[newRow][newCol]=='E'){
                        neighbors.add(new int[]{newRow,newCol});
                    }
                    }
                }
                if(adjMines>0){
                    board[row][col] = (char)(adjMines+'0');
                }
                else{
                    board[row][col] = 'B';
                    for(int[] neighbor : neighbors){
                        int neighborRow = neighbor[0];
                        int neighborCol = neighbor[1];
                        if(!visited[neighborRow][neighborCol]){
                            bfsQueue.offer(new int[]{neighborRow, neighborCol});
                            visited[neighborRow][neighborCol]=true;
                        }
                    }
                }
            }
        }
        return board;
    }
}
