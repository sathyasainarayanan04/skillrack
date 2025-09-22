class Solution {
    public int findLengthOfShortestSubarray(int[] array) {
       int arrayLength = array.length;
       int leftEnd = 0;
       while(leftEnd < arrayLength-1 && array[leftEnd] <= array[leftEnd+1]){
        leftEnd++;
       }
       if(leftEnd == arrayLength-1) return 0;
       int rightStart = arrayLength-1;
       while(rightStart > 0 && array[rightStart-1] <= array[rightStart]){
        rightStart--;
       }
       int minRemoval = Math.min(rightStart, arrayLength - (leftEnd+1));
       int leftIndex = 0;
       int rightIndex = rightStart;
       while(leftIndex <= leftEnd && rightIndex < arrayLength){
        if(array[leftIndex] <= array[rightIndex]){
            minRemoval = Math.min(minRemoval, rightIndex-(leftIndex+1));
            leftIndex++;
        }
        else{
            rightIndex++;
        }
       }
       return minRemoval;
    }
}
