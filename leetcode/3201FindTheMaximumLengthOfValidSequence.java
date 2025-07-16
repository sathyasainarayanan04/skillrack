class Solution {
    public int maximumLength(int[] nums) {
        int parity[][] = new int[][]{{0,0},{1,0},{0,1},{1,1}};
        int[] numsModuloTwo = new int[nums.length];
        for(int index = 0; index<nums.length; index++){
            numsModuloTwo[index] = nums[index]%2;
        }
        int finalCount = 0;
        for(int index=0;index<4;index++){
            int par[] = parity[index];
            int count = 0;
            for(int num=0;num<nums.length;num++){
                if(numsModuloTwo[num] == par[count%2]){
                    count++;
                }
            }
            finalCount = Math.max(finalCount, count);
        }
        return finalCount;
    }
}
