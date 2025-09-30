class Solution {
    public int minCityConnectedUsingDijikstra(int numberOfCities, int sourceCity, Map<Integer, List<int[]>> graph, int distanceThreshold){
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1], b[1])
        );
        pq.add(new int[]{sourceCity, 0});
        int[] minDistance = new int[numberOfCities];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[sourceCity] = 0;
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentCity = current[0];
            int currentDistance = current[1];
            if(currentDistance > minDistance[currentCity]) continue;
            for(int[] neighbor : graph.get(currentCity)){
                int neighborCity = neighbor[0];
                int neighborDistance = neighbor[1];
                if((currentDistance + neighborDistance) < minDistance[neighborCity]){
                    minDistance[neighborCity] = currentDistance + neighborDistance;
                    pq.offer(new int[]{neighborCity, (currentDistance + neighborDistance)});
                }
            }
        }
        int minDistanceCities = 0;
        for(int index =0; index < numberOfCities; index++){
            if(minDistance[index] <= distanceThreshold){
                minDistanceCities++;
            }
        }
        return minDistanceCities;
    }
    public int findTheCity(int numberOfCities, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int index =0; index < numberOfCities; index++){
            graph.put(index, new ArrayList<>());
        }
        for(int index =0; index < edges.length; index++){
            int fromCity = edges[index][0];
            int destinationCity = edges[index][1];
            int distance = edges[index][2];
            graph.get(fromCity).add(new int[]{destinationCity, distance});
            graph.get(destinationCity).add(new int[]{fromCity, distance});
        }
        int numberOfMinDistanceCities = Integer.MAX_VALUE;
        int minDistanceCity = -1;
        for(int sourceCity =0; sourceCity < numberOfCities; sourceCity++){
            int currentNumberOfMinDistanceCities = minCityConnectedUsingDijikstra(numberOfCities, sourceCity, graph, distanceThreshold);
            if (currentNumberOfMinDistanceCities < numberOfMinDistanceCities ||
    (currentNumberOfMinDistanceCities == numberOfMinDistanceCities && sourceCity > minDistanceCity)) {
    numberOfMinDistanceCities = currentNumberOfMinDistanceCities;
    minDistanceCity = sourceCity;
}

        }
        return minDistanceCity;
    }
}fnfin
