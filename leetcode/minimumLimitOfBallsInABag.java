class Solution {
    public boolean isValidBagSize(int bagSize, int[] ballsInBags, int maxSplits){
        int splitsUsed = 0;
        for(int balls : ballsInBags){
            splitsUsed += (int)(Math.ceil((double) balls/bagSize)-1);
            if(splitsUsed > maxSplits)return false;
        }
        return true;
    }
    public int minimumSize(int[] ballsInBags, int maxSplits) {
        int low = 1;
        int high = 0;
        for(int balls : ballsInBags){
            high = Math.max(balls, high);
        }
        int result = high;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isValidBagSize(mid, ballsInBags, maxSplits)){
                result = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }
}
