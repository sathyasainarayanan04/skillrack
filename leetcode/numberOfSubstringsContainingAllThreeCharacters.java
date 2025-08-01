class Solution {
    public int numberOfSubstrings(String input) {
        Map<Character,Integer> frequencyMap = new HashMap<>();
        int leftIndex =0;
        int count = 0;
        for(int right =0;right<input.length();right++){
            char ch = input.charAt(right);
            if(frequencyMap.getOrDefault(ch,0)==0)
            frequencyMap.put(ch,right);
            else{
                frequencyMap.remove(ch);
                frequencyMap.put(ch,right);
            }
            if(frequencyMap.size()>2){
                int min = Integer.MAX_VALUE;
                for(int num : frequencyMap.values()){
                  min = Math.min(num,min);
                }
                System.out.println(min);
                count = count + (min-leftIndex+1);
            }
        }
        return count;
    }
}
