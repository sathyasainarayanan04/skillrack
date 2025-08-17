class Solution {
    public void bfsFindProvinces(int[][] isConnected, boolean[] visited, int city){
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(city);
        visited[city] = true;
        while(!bfsQueue.isEmpty()){
            int currentCity = bfsQueue.poll();
            visited[currentCity] = true;
            for(int index=0; index<isConnected.length;index++){
                if(isConnected[currentCity][index]==1 && !visited[index]){
                    bfsQueue.offer(index);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int totalCities = isConnected.length;
        boolean[] visited = new boolean[totalCities];
        int provinceCount = 0;
        for(int city=0; city<totalCities;city++){
            if(!visited[city]){
                bfsFindProvinces(isConnected, visited, city);
                provinceCount++;
            }
        }
        return provinceCount;
    }
}
