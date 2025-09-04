class Solution {
    public boolean canCompleteWithInDays(int[] weights, int days, int capacity){
        int currentWeight = 0;
        int currentDays = 1;
        for(int weight : weights){
            if(currentWeight + weight <= capacity){
               currentWeight = currentWeight+weight;
            }
            else{
                currentDays++;
                currentWeight = weight;
            }
        }
        return currentDays<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maximumCapacity =0, minimumCapacity =0;
        for(int weight : weights){
            maximumCapacity = weight+maximumCapacity;
            minimumCapacity = Math.max(minimumCapacity,weight);
        }
        int answer = 0;
        while(minimumCapacity <= maximumCapacity){
            int mid = minimumCapacity + (maximumCapacity - minimumCapacity)/2;
            if(canCompleteWithInDays(weights,days,mid)){
                answer = mid;
                maximumCapacity = mid-1;
            }
            else{
                minimumCapacity = mid+1;
            }
        }
        return answer;
    }
}
