class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left =0, right = arr.length-k;
        while(left < right){
            int mid = left + (right-left)/2;
            int distanceToLeft = (-arr[mid] + x);
            int distanceToRight = (arr[mid+k]-x);
            if(distanceToLeft > distanceToRight)left = mid+1;
            else right = mid;
        }
        int windowStart = left;
        int windowEnd = left + k;
        List<Integer> answerList = new ArrayList<>();
        for(int index = windowStart ; index<windowEnd; index++){
            answerList.add(arr[index]);
        }
        return answerList;
    }
}
