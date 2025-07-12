class Solution {
    public int[][] spiralMatrixIII(int R, int C, int rStart, int cStart) {
      int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
      List<int[]> ans = new ArrayList<>();
      int rows = rStart;
      int cols = cStart;
      int steps = 1;
      int Direction = 0;
      ans.add(new int[]{rows,cols});
      while(ans.size()<R*C){
        for(int sameStepSize =0; sameStepSize<2;sameStepSize++){
           for(int step=0;step<steps;step++){
            rows = rows+directions[Direction%4][0];
            cols = cols+directions[Direction%4][1];
            if(rows<R && cols<C && rows>=0 && cols>=0){
            ans.add(new int[]{rows,cols});
        }
        }
        Direction++; 
        }
        steps++;
      }
      int[][] result = new int[R*C][2];
      for(int index=0;index<ans.size();index++){
          int[] list = ans.get(index);
          result[index][0]=list[0];
          result[index][1]=list[1];
      }
      return result;
    }
}
