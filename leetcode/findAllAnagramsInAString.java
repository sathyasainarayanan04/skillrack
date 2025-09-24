class Solution {
    public List<Integer> findAnagrams(String text, String pattern) {
        List<Integer> startingIndexes = new ArrayList<>();
        if(pattern.length() > text.length())
        return startingIndexes;
        int[] patternFrequency = new int[26];
        int[] windowFrequency = new int[26];
        for(char ch : pattern.toCharArray()){
            patternFrequency[ch - 'a']++;
        }
        int windowSize = pattern.length();
        int start = 0;
        int end =0;
        while(end < text.length()){
            char charToAdd = text.charAt(end);
            windowFrequency[charToAdd - 'a']++;
            if(end - start + 1 > windowSize){
                windowFrequency[text.charAt(start) - 'a']--;
                start++;
            }
            if(end - start + 1 == windowSize){
               if(Arrays.equals(patternFrequency, windowFrequency))
               startingIndexes.add(start);
            }
        end++;
        }
        return startingIndexes;
    }
}
