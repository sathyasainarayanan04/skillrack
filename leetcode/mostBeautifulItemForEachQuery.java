class Solution {
    public int binarySearch(int[] prices, int currentBudget){
        int left = 0, right = prices.length-1;
        int answerIndex = -1;
        while(left <= right){
          int mid = left + (right-left)/2;
          if(prices[mid] <= currentBudget){
            answerIndex = mid;
            left = mid+1;
          }
          else{
           right = mid-1;
          }
        }
        return answerIndex;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
    Arrays.sort(items, (item1,item2)->Integer.compare(item1[0],item2[0]));
    int[] prices = new int[items.length];
    int maxBeautyTillNow[] = new int[items.length];
    int maxBeauty = 0;
    for(int index=0; index<items.length; index++){
        prices[index] = items[index][0];
        maxBeauty = Math.max(maxBeauty, items[index][1]);
        maxBeautyTillNow[index] = maxBeauty;
    }
    int[] resultArray = new int[queries.length];
    for(int index=0; index<queries.length; index++){
        int currentBudget = queries[index];
        int answerIndex = binarySearch(prices, currentBudget);
        if(answerIndex != -1){
            resultArray[index] = maxBeautyTillNow[answerIndex];
        }
        else{
            resultArray[index] = 0;
        }
    }
    return resultArray;
    }
}
