class Solution {
    public String largestNumber(int[] array) {
      
        for(int index=0;index<array.length-1;index++){
            
            for(int jindex=index+1;jindex<array.length;jindex++){
                String indexstr = String.valueOf(array[index]);
                String jindexstr = String.valueOf(array[jindex]);
                String indexjindex = indexstr+jindexstr;
                String jindexindex = jindexstr+indexstr;
                if(jindexindex.compareTo(indexjindex)>0){
                    int temp = array[index];
                    array[index]=array[jindex];
                    array[jindex]=temp;
                }
            }
        }
        if(array[0]==0)return "0";
        String str = "";
        for(int arr: array){
            str+=String.valueOf(arr);
        }
        return str;
    }
}
