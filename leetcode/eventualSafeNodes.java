import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{   
    public List<Integer> eventualSafeNodes(int[][] graph){
        int totalNodes = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for(int node = 0; node<totalNodes; node++){
            reverseGraph.add(new ArrayList<>());
        }
        int[] outDegree = new int[totalNodes];
        for(int node=0; node<totalNodes ; node++){
            for(int neighbor : graph[node]){
                reverseGraph.get(neighbor).add(node);
            }
            outDegree[node] = graph[node].length;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int node =0; node<totalNodes; node++){
            if(outDegree[node] == 0)
            queue.offer(node);
        }
        boolean[] isSafe = new boolean[graph.length];
        while(!queue.isEmpty()){
            int safeNode = queue.poll();
            isSafe[safeNode] = true;
            for(int prevNode : reverseGraph.get(safeNode)){
                outDegree[prevNode]--;
                if(outDegree[prevNode]==0)queue.offer(prevNode);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int node =0;node<graph.length;node++){
            if(isSafe[node])result.add(node);
        }
        return result;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Solution solution = new Solution();
		int[][] graph = {
		    {1,2},
		    {2,3},
		    {5},
		    {0},
		    {5},
		    {},
		    {}
		};
		List<Integer> safeNodes = solution.eventualSafeNodes(graph);
        System.out.println(safeNodes);
	}
}
