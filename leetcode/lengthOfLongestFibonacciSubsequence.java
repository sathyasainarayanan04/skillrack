class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> numberSet = new HashSet<>();
        for(int element : arr){
            numberSet.add(element);
        }
        int maxElement = arr[n-1];
        int longestLength = 0;
        for(int firstIndex=0;firstIndex<n;firstIndex++){
            for(int secondIndex=firstIndex+1;secondIndex<n;secondIndex++){
                int first = arr[firstIndex];
                int second = arr[secondIndex];
                int currentLength = 2;
                while(first + second <= maxElement && numberSet.contains(first+second)){
                    int next = first + second;
                    first = second;
                    second = next;
                    currentLength++;
                }
                longestLength = Math.max(currentLength, longestLength);
            }
        }
        return longestLength>2?longestLength:0;
    }
}
