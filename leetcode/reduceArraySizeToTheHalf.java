class Solution {
    public int minSetSize(int[] arr) {
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> frequencyList = new ArrayList<>(map.values());
        Collections.sort(frequencyList, Collections.reverseOrder());
        int count = 0;
        int totalElement = length;
        int index =0;
        while(totalElement > length/2){
            totalElement = totalElement - frequencyList.get(index);
            index++;
            count++;
        }
        return count;
    }
}
