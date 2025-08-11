class Solution {
    public int[] digitsCount(int number){
        int countMap[] = new int[10];
        while(number > 0){
            countMap[number%10]++;
            number = number/10;
        }
        return countMap;
    }
    public boolean isSameCount(int[] countMap1, int[] countMap2){
        for(int index=0;index<10;index++){
            if(countMap1[index]!=countMap2[index])return false;
        }
        return true;
    }
    public boolean reorderedPowerOf2(int n) {
        int numberCount[] = digitsCount(n);
        for(int index =0;index<32;index++){
            int currentPower = 1<<index;
            int[] currentPowerMap = digitsCount(currentPower);
            if(isSameCount(numberCount,currentPowerMap))return true;
        }
        return false;
    }
}
