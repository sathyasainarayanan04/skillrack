class Solution {
    public int findRightPosition(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int index = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                index = mid;
                low = mid+1;
            }
            else if(nums[mid] > target){
                 high = mid-1;
            }
            else{
              low = mid+1;
            }
        }
        return index;
    }
    public int findLeftPosition(int[] nums, int target){
        int low = 0, high = nums.length-1;
        int index = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                index = mid;
                high = mid-1;
            }
            else if(nums[mid]>=target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findLeftPosition(nums,target);
        int rightIndex = findRightPosition(nums, target);
        return new int[]{leftIndex, rightIndex};
    }
}
