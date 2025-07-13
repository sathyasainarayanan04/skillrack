class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int rectBreadth = right-left;
            int rectHeight = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,rectHeight*rectBreadth);
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
}
