class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        Map<Integer,List<Integer>> frequencyMap = new HashMap<>();
        for(int row=0; row<R;row++){
            for(int col=0;col<C;col++){
                int key = row+col;
                if(!frequencyMap.containsKey(key)){
                    frequencyMap.put(key, new ArrayList<>());
                }
                frequencyMap.get(key).add(mat[row][col]);
            }
        }
        int count =0;
        int[] resultArray = new int[R*C];
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : frequencyMap.entrySet()){
            if(count%2==0){
                List<Integer> resultSet = entry.getValue();
                int size = resultSet.size();
                for(int element = size-1; element>=0; element--){
                    resultArray[index] = resultSet.get(element);
                    index++;
                }
            }
            else{
                List<Integer> resultSet = entry.getValue();
                for(int element : resultSet){
                    resultArray[index] = element;
                    index++;
                }
            }
            count++;
        }
        return resultArray;
    }
}
