class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });
        int maximum = intervals[0][1];
        int removeCount = 0;
        for(int index=1;index<intervals.length;index++){
            if(intervals[index][1]>maximum){
                maximum = intervals[index][1];
                continue;
            }
            else{
                removeCount++;
            }
        }
        return intervals.length-removeCount;
    }
}
