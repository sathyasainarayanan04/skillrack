class Solution {
   
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        merged.add(new int[]{intervals[0][0], intervals[0][1]});
        int R = intervals.length;
        for(int row = 1; row<R; row++){
            int mergedEnd = merged.get(merged.size()-1)[1];
            int currentStart = intervals[row][0];
            int currentEnd = intervals[row][1];
            int mergedStart = merged.get(merged.size()-1)[0];
            if(currentStart>mergedEnd){
                merged.add(new int[]{currentStart, currentEnd});
            }
            else{
                int newStart = mergedStart;
                int newEnd = Math.max(currentEnd,mergedEnd);
                merged.remove(merged.size()-1);
                merged.add(new int[]{newStart,newEnd});
            }
        }
        int[][] resultArray = merged.toArray(new int[merged.size()][]);
        return resultArray;
    }
}
