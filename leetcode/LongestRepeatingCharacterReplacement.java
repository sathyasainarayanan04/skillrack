class Solution {
    public int getMaximumFrequency(Map<Character,Integer> frequencyMap){
        int maxFrequency = 0;
        for(int freq : frequencyMap.values()){
            maxFrequency = Math.max(freq,maxFrequency);
        }
        return maxFrequency;
    }
    public int characterReplacement(String s, int k) {
        int left =0; 
        int right = 0;
        int maximumLength = 0;
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(right =0;right<s.length(); right++){
            char ch = s.charAt(right);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch,0)+1);
            while((right-left+1) - getMaximumFrequency(frequencyMap) > k){
                char leftCharacter = s.charAt(left);
                frequencyMap.put(leftCharacter, frequencyMap.get(leftCharacter)-1);
                if(frequencyMap.get(leftCharacter)==0)
                   frequencyMap.remove(leftCharacter);
                left++;
            }
            maximumLength = Math.max(maximumLength, right-left+1);
        }
        return maximumLength;
    }
}
