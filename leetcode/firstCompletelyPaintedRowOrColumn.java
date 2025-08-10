//approach 1 
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,int[]> locationMap = new HashMap<>();
        int R = mat.length;
        int C = mat[0].length;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                int element = mat[row][col];
                locationMap.put(element,new int[]{row,col});
            }
        }
        int[] rowCount = new int[R];
        int[] colCount = new int[C];
        for(int index=0;index<arr.length;index++){
            int element = arr[index];
            int position[] = locationMap.get(element);
            rowCount[position[0]]++;
            colCount[position[1]]++;
            if(colCount[position[1]]==R || rowCount[position[0]]==C ){
                return index;
            }
        }
        return 0;
    }
}

/*
time complexity for this approach:
O(RxC)
space complexity:
location map stores O(RxC)
rowmap O(rowSize)
colmap O(colSize)
O(rowSize+colSize)
O(N) space totally
*/

//another approach without hash map 
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[][] locationMap = new int[arr.length+1][2];
        int R = mat.length;
        int C = mat[0].length;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                int element = mat[row][col];
                locationMap[element][0] = row;
                locationMap[element][1] = col;
            }
        }
        int[] rowCount = new int[R];
        int[] colCount = new int[C];
        for(int index=0;index<arr.length;index++){
            int element = arr[index];
            int position[] = locationMap[element];
            rowCount[position[0]]++;
            colCount[position[1]]++;
            if(colCount[position[1]]==R || rowCount[position[0]]==C ){
                return index;
            }
        }
        return 0;
    }
}

/*
same code with same functionality have beats 90% of submissions, previous approach just beats 20% alone
time complexity : O(RxC)
space complexity : O(N)
*/
