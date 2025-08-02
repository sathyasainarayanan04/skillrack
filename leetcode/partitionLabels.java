class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> lastIndexMap = new HashMap<>();
        for(int index = s.length()-1;index>=0;index--){
            char ch = s.charAt(index);
            if(!lastIndexMap.containsKey(ch)){
                lastIndexMap.put(ch,index);
            }
        }
        List<String> partitions = new ArrayList<>();
        for(int index =0;index<s.length();){
            char ch = s.charAt(index);
            int startIndex = index;
            int endIndex = lastIndexMap.get(ch);
            for(int start = startIndex+1;start<endIndex;start++){
                char newChar = s.charAt(start);
                int lastIndexOfNewChar = lastIndexMap.get(newChar);
                if(lastIndexOfNewChar>endIndex){
                    endIndex=lastIndexOfNewChar;
                }
            }
            String partition = s.substring(startIndex,endIndex+1);
            partitions.add(partition);
            index = endIndex+1;
        }
        List<Integer> partitionSize = new ArrayList<>();
        for(String str : partitions){
            partitionSize.add(str.length());
        }
        return partitionSize;
    }
}
