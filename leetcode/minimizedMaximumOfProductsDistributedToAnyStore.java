class Solution {
   public boolean canDistribute(int middle, int[] quantities, int storeCount){
       int[] storeArray = new int[storeCount];
       int qty = 0;
       for(int index=0; index<storeCount; index++){
          if(qty < quantities.length && quantities[qty] > 0){
            int toBePlaced = quantities[qty] - middle;
            if(toBePlaced<=0){
                storeArray[index] = 0;
                quantities[qty] = 0;
                qty++;
            }
            else{ 
                storeArray[index] = middle;
                quantities[qty] = toBePlaced;
            }
          }
       }
       for(int index=0; index<quantities.length; index++){
        if(quantities[index]!=0)return false;
       }
       return true;
    }
    public int[] cloneArray(int[] quantities){
        int[] newArray = new int[quantities.length];
        for(int index=0; index<quantities.length; index++){
            newArray[index] = quantities[index];
        }
        return newArray;
    }
    public int minimizedMaximum(int storeCount, int[] quantities) {
        int left = 0, right = 0;
        int maximumQuantity = Integer.MIN_VALUE;
        for(int quantity : quantities){
            maximumQuantity = Math.max(maximumQuantity, quantity);
        }
        right = maximumQuantity;
        int minimizedMaximumLoad = 0;
        while(left <= right){
            int clone[] = cloneArray(quantities);
            int middle = left + (right-left)/2;
            if(canDistribute(middle, clone, storeCount)){
                minimizedMaximumLoad = middle;
                right = middle-1;
            }
            else{
                left = middle+1;
            }
        }
        return minimizedMaximumLoad;
    }
}
