class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int currentSum = 0;
        for(int index =0; index < k; index++){
            currentSum += cardPoints[index];
        }
        int maxPoints = currentSum;
        int leftIndex = k-1;
        int rightIndex = cardPoints.length-1;
        while(leftIndex >= 0){
            currentSum -= cardPoints[leftIndex];
            currentSum += cardPoints[rightIndex];
            maxPoints = Math.max(maxPoints, currentSum);
            leftIndex--;
            rightIndex--;
        }
        return maxPoints;
    }
}
