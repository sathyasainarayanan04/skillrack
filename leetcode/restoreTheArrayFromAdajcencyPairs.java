class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int[] pair : adjacentPairs){
            if(!adjacencyList.containsKey(pair[0])){
                adjacencyList.put(pair[0], new ArrayList<>());
            }
            if(!adjacencyList.containsKey(pair[1])){
                adjacencyList.put(pair[1], new ArrayList<>());
            }
            adjacencyList.get(pair[0]).add(pair[1]);
            adjacencyList.get(pair[1]).add(pair[0]);
        }
        int start = -1;
        for(int key : adjacencyList.keySet()){
            if(adjacencyList.get(key).size()==1){
                start = key;
                break;
            }
        }
        int[] result = new int[adjacentPairs.length+1];
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(start);
        int arrayIndex=0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while(!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            for(int index=0;index<size;index++){
                int element = bfsQueue.poll();
                result[arrayIndex] = element;
                arrayIndex++;
                for(int neighbor : adjacencyList.get(element)){
                    if(!visited.contains(neighbor)){
                        bfsQueue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return result;
    }
}
