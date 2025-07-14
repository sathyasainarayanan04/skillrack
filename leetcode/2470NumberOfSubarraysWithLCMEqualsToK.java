class Solution {
    public int GCD(int a, int b){
        while(b!=0){
            int remainder = a%b;
            a = b;
            b = remainder;
        }
        return a;
    }
    public int LCM(int a, int b){
        return (a*b)/GCD(a,b);
    }
    public int subarrayLCM(int[] nums, int k) {
        int count = 0;
        for(int index =0;index<nums.length;index++){
            int currentLCM = nums[index];
            if(nums[index]==k){
              count++;
            }
            for(int jindex=index+1;jindex<nums.length; jindex++){
                currentLCM = LCM(currentLCM, nums[jindex]);
                if(currentLCM==k){
                    count++;
                }
                else if(currentLCM>k){
                    break;
                }
            }
        }
        
        return count;
    }
}
