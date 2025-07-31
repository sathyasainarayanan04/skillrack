class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[] = new int[256];
        int leftIndex=0;
        int maxLength = 0;
        for(int rightIndex = 0;rightIndex<s.length();rightIndex++){
           char ch = s.charAt(rightIndex);
           hash[ch]++;
           while(hash[ch]>1 && leftIndex<rightIndex){
            hash[s.charAt(leftIndex)]--;
            leftIndex++;
           }
           maxLength = Math.max(maxLength,rightIndex-leftIndex+1);
        }
        return maxLength;
    }
}
