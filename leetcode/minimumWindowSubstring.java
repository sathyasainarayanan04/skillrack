class Solution {
    public String minWindow(String input, String target) {
        Map<Character, Integer> targetFreq = new HashMap<>();
        for(char ch : target.toCharArray()){
            targetFreq.put(ch, targetFreq.getOrDefault(ch,0)+1);
        }
        int required = targetFreq.size();
        int formed = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();
    int left =0, right =0, minLength = Integer.MAX_VALUE, minStart =-1;
        while(right< input.length()){
            char ch = input.charAt(right);
            windowFreq.put(ch, windowFreq.getOrDefault(ch,0)+1);
            if(targetFreq.containsKey(ch) && targetFreq.get(ch).intValue() == windowFreq.get(ch).intValue()){
                formed++;
            }
            while(left <= right && formed == required){
                char leftChar = input.charAt(left);
                int windowLength = right - left +1;
                if(windowLength < minLength){
                    minLength = windowLength;
                    minStart = left;
                }
                windowFreq.put(leftChar, windowFreq.get(leftChar)-1);
                if(targetFreq.containsKey(leftChar)){
                    int currentCount = windowFreq.get(leftChar);
                    int requiredCount = targetFreq.get(leftChar);
                    if(currentCount < requiredCount)formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : input.substring(minStart, minStart+minLength);
    }
}
