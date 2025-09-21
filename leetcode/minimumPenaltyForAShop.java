class Solution {
    public int bestClosingTime(String customers) {
        int[] suffixArray = new int[customers.length()+1];
        int suffix = 0;
        if(customers.indexOf('Y')==-1)return 0;
        suffixArray[suffixArray.length-1] = 0;
        for(int index= customers.length()-1; index>-1; index--){
            if(customers.charAt(index) == 'Y'){
                suffix++;
            }
            suffixArray[index] = suffix;
        }
        int bestHour = 0;
        int minPenalty = suffixArray[0];
        int prefix = 0;
        for(int index =0; index<customers.length(); index++){
            int current = customers.charAt(index) == 'Y' ? 0 :1;
            prefix += current;
            int currentPenalty = prefix + suffixArray[index+1];
            if(currentPenalty < minPenalty){
                bestHour = index+1;
                minPenalty = currentPenalty;
            }
        }
        return bestHour;
    }
}
