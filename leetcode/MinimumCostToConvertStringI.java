class Solution {
    public long minimumCost(String sourceString, String targetString, char[] originalChars, char[] changedChars, int[] cost) {
        int numLetters = 26;
        int INF = 1_000_000_000;
        int[][] minCostMatrix = new int[numLetters][numLetters];
        for(int row =0; row<numLetters; row++){
            Arrays.fill(minCostMatrix[row], INF);
            minCostMatrix[row][row] = 0;
        }
        for(int index=0; index<originalChars.length; index++){
            int from = originalChars[index] - 'a';
            int to = changedChars[index] - 'a';
            minCostMatrix[from][to] = Math.min(minCostMatrix[from][to], cost[index]);
        }
        for(int intermediate = 0; intermediate<numLetters; intermediate++){
            for(int source = 0; source < numLetters; source++){
                for(int target =0; target<numLetters; target++){
                    int sourceToIntermediate = minCostMatrix[source][intermediate];
                    int intermediateToTarget = minCostMatrix[intermediate][target];
                    if(((sourceToIntermediate + intermediateToTarget) < INF) && minCostMatrix[source][target]>(sourceToIntermediate + intermediateToTarget)){
                        minCostMatrix[source][target] = sourceToIntermediate + intermediateToTarget;

                    }
                }
            }
        }
        long totalCost = 0;
        for(int index=0; index<targetString.length();index++){
            int source = sourceString.charAt(index) - 'a';
            int target = targetString.charAt(index) - 'a';
            if(minCostMatrix[source][target] >= INF)return -1;
            totalCost += minCostMatrix[source][target];
        }
        return totalCost;
    }
}
