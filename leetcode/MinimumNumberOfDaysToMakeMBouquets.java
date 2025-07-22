class Solution {
    public boolean isPossible(int[] bloomDay,int current, int numberOfBouquets, int FlowersRequired){
        int count = 0;
        int numberOfBouqetsFormed = 0;
        for(int num : bloomDay){
           if(num<=current){
            count++;
           }
           else{
            numberOfBouqetsFormed+=(count/FlowersRequired);
            count=0;
           }
        }
        numberOfBouqetsFormed += (count/FlowersRequired);
        return numberOfBouqetsFormed >= numberOfBouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length)return -1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int num : bloomDay){
            left = Math.min(left,num);
            right = Math.max(right,num);
        }
        int MinDays = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(bloomDay,mid,m,k)){
                MinDays = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return MinDays;
    }
}
