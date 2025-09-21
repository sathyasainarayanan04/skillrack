class Solution {
    public boolean areFrequenciesEqual(int[] patternFrequency, int[] windowFrequency){
        for(int index=0; index<windowFrequency.length; index++){
            if(patternFrequency[index]!=windowFrequency[index])return false;
        }
        return true;
    }
    public boolean checkInclusion(String pattern, String text) {
        if(pattern.length() > text.length())return false;
        int[] patternFrequency = new int[26];
        int[] windowFrequency = new int[26];
        for(char ch : pattern.toCharArray()){
            patternFrequency[ch - 'a']++;
        }
        int patternLength = pattern.length();
        for(int index = 0; index<patternLength; index++){
            windowFrequency[text.charAt(index) - 'a']++;
        }
        if(areFrequenciesEqual(patternFrequency, windowFrequency))return true;
        for(int rightIndex=patternLength; rightIndex<text.length(); rightIndex++){
            int leftIndex = rightIndex - patternLength;
            windowFrequency[text.charAt(leftIndex) - 'a']--;
            windowFrequency[text.charAt(rightIndex) - 'a']++;
            if(areFrequenciesEqual(patternFrequency, windowFrequency))return true;
        }
        return false;
    }
}
