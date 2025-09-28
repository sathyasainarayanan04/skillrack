class Solution {
     static class Edge{
    int targetNode;
    double probability;
    Edge(int targetNode, double probability){
      this.targetNode = targetNode;
      this.probability = probability;
    }
  }
  public static double maxProbability(int numberOfNodes, int[][] edges, double[] probabilities, int start, int end){
    Map<Integer, List<Edge>> graph = new HashMap<>();
    for(int index =0; index<numberOfNodes; index++){
      graph.put(index, new ArrayList<>());
    }
    for(int index =0; index< edges.length; index++){
      int nodeA = edges[index][0];
      int nodeB = edges[index][1];
      graph.get(nodeA).add(new Edge(nodeB, probabilities[index]));
      graph.get(nodeB).add(new Edge(nodeA, probabilities[index]));
    }
    PriorityQueue<double[]> pq = new PriorityQueue<>(
      (a,b) -> Double.compare(b[1],a[1])
      );
    pq.offer(new double[]{start,1});
    double[] maxProbability = new double[numberOfNodes];
    maxProbability[start] = 1;
    while(!pq.isEmpty()){
      double[] current = pq.poll();
      int node = (int) current[0];
      double probability = current[1];
      if(node == end) return probability;
      for(Edge e : graph.get(node)){
        double newProbability = probability * e.probability;
        if(newProbability > maxProbability[e.targetNode]){
          maxProbability[e.targetNode] = newProbability;
          pq.offer(new double[]{e.targetNode, newProbability});
        }
      }
    }
    return 0.0;
  }
}
