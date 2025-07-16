class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1],b[1]));
        List<int[]> mergedLists = new ArrayList<>();
        mergedLists.add(new int[]{intervals[0][0], intervals[0][1]});
        int removeCount = 0;
        for(int index=1; index< intervals.length;index++){
           if(intervals[index][0] < mergedLists.get(mergedLists.size()-1)[1]){
            removeCount++;
            continue;
           }
           else{
            mergedLists.add(new int[]{intervals[index][0], intervals[index][1]});
           }
    }
        return removeCount;

}
}
