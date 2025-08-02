class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        List<int[]> result = new ArrayList<>();
        for(int index=0;index<people.length;index++){
            int position = people[index][1];
            result.add(position,new int[]{people[index][0],people[index][1]});
        }
        return result.toArray(new int[people.length][]);
    }
}
