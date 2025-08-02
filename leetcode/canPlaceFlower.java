class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count =0;
       if(flowerbed.length==1){
        if(flowerbed[0]==0 && n==1)return true;
        else if(flowerbed[0]==1 && n==0)return true;
        else if(flowerbed[0]==0 && n==0)return true;
        return false;
       }
        for(int index=0;index<flowerbed.length;index++){
            if(count>=n)return true;
        if(index==0){
            if(index+1 <flowerbed.length && flowerbed[index]==0 && flowerbed[index+1]==0){
              count++;
              flowerbed[index]=1;
            }
        }
        else if(index==flowerbed.length-1){
            if(flowerbed[index-1]==0 && flowerbed[index]==0){
                count++;
                flowerbed[index]=1;
            }
        }
        else{
            if(index+1<flowerbed.length && flowerbed[index-1]==0 && flowerbed[index]==0 && flowerbed[index+1]==0 )
            {count++;
            flowerbed[index]=1;}
        }
        }
        return count==n;
    }
}
