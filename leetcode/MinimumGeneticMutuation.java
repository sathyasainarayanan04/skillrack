class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene))return 0;
        Queue<String> bfsQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
        bfsQueue.offer(startGene);
        visited.add(startGene);
        int currentLevel = 0;
        char[] choices = {'A','C','G','T'};
        Set<String> validMutuations = new HashSet<>();
        while(!bfsQueue.isEmpty()){
           int levelSize = bfsQueue.size();
           for(int i = 0; i<levelSize; i++){
            String string = bfsQueue.poll();
            if(geneBank.contains(string)){
               validMutuations.add(string);
            }
            if(endGene.equals(string)){
                return currentLevel;
            }
            StringBuilder currentString = new StringBuilder();
            currentString.append(string);
            for(int index=0;index<currentString.length();index++){
                char originalChar = string.charAt(index);
                for(char ch : choices){
                   currentString.setCharAt(index,ch);
                   if(!visited.contains(currentString.toString()) && geneBank.contains(currentString.toString())){
                    bfsQueue.offer(currentString.toString());
                    visited.add(currentString.toString());
                   }
                }
                currentString.setCharAt(index,originalChar);
            }
           }
           currentLevel++;
        }
        return -1;
    }
}
