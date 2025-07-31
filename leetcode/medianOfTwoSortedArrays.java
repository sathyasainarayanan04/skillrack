/*https://chatgpt.com/share/688b0394-a210-8009-bea6-26f868c16a45*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1>length2){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            length1 = nums1.length;
            length2 = nums2.length;
        }
        int totalLength = length1 + length2;
        int left = 0;
        int right = length1;
        while(left<=right){
            int partition1 = left + (right-left)/2;
            int partition2 = (totalLength+1)/2-partition1;
            int maxLeft1 = (partition1==0)?Integer.MIN_VALUE : nums1[partition1-1];
            int minRight1 = (partition1==length1)?Integer.MAX_VALUE:nums1[partition1];
            int maxLeft2 = (partition2==0)?Integer.MIN_VALUE : nums2[partition2-1];
            int minRight2 = (partition2==length2)?Integer.MAX_VALUE:nums2[partition2];
            if(maxLeft1<=minRight2 && maxLeft2 <= minRight1){
              if(totalLength %2 ==0){
                return (Math.max(maxLeft1,maxLeft2) + Math.min(minRight1,minRight2))/2.0;
              }
              else{
                return Math.max(maxLeft1,maxLeft2);
              }
            }
            else if(maxLeft1>minRight2){
                right = partition1-1;
            }
            else {
                left = partition1+1;
            }
        }
        return 0.0;
    }
}
