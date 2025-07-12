class Solution {
    static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public void isBelongToTheOcean(int[][] matrix,int row, int col, boolean[][] ocean){
        ocean[row][col]=true;
        int R = matrix.length;
        int C = matrix[0].length;
        int currentValue = matrix[row][col];
        for(int dir[] : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow<R && newCol<C && newRow>=0 && newCol>=0 && matrix[newRow][newCol]>=currentValue){
                if(!ocean[newRow][newCol]){
                    isBelongToTheOcean(matrix,newRow,newCol,ocean);
                }
            }
        }
    }
    public void display(boolean[][] matrix){
        for(int row =0;row<matrix.length; row++){
            for(int col =0;col<matrix[0].length;col++){
                System.out.print((matrix[row][col]==true ? "T" : "F" )+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         List<List<Integer>> common = new ArrayList<>();
         int R = heights.length;
         int C = heights[0].length;
         List<int[]> pacific = new ArrayList<>();
         List<int[]> atlantic = new ArrayList<>();
         boolean[][] pacificVisited = new boolean[R][C];
         boolean[][] atlanticVisited = new boolean[R][C];
         for(int col =0;col<C;col++){
             isBelongToTheOcean(heights,0,col,pacificVisited);
             isBelongToTheOcean(heights,R-1,col,atlanticVisited);
         }
         for(int row =0;row<R;row++){
            isBelongToTheOcean(heights,row,0,pacificVisited);
            isBelongToTheOcean(heights,row,C-1,atlanticVisited);
         }
         System.out.println("Pacific Visited: ");
         display(pacificVisited);
         System.out.println("Atlantic Visited: ");
         display(atlanticVisited);
         for(int row =0;row<R;row++){
            for(int col=0;col<C;col++){
                if(pacificVisited[row][col] && atlanticVisited[row][col]){
                    List<Integer> list = new ArrayList<>();
                    list.add(row);
                    list.add(col);
                    common.add(list);
                }
            }
         }
         for(List<Integer> l : common){
            System.out.print(l+" ");
         }
         return common;
    }
}
