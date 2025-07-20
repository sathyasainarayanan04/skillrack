class Solution {
    public boolean canFinish(int totalCourses, int[][] prerequisites) {
       Map<Integer, List<Integer>> graph = new HashMap<>();
       int[] prerequisiteForEveryCourse = new int[totalCourses];
       for(int index = 0;index<prerequisites.length; index++){
           int course = prerequisites[index][0];
           int prerequisite = prerequisites[index][1];
           if(!graph.containsKey(prerequisite)){
            graph.put(prerequisite, new ArrayList<>());
           }
           graph.get(prerequisite).add(course);
           prerequisiteForEveryCourse[course]++;
       }
       Queue<Integer> bfsQueue = new LinkedList<>();
       boolean visited[] = new boolean[totalCourses];
       for(int index =0 ;index < prerequisiteForEveryCourse.length;index++){
         if(prerequisiteForEveryCourse[index]==0){
            bfsQueue.offer(index);
            visited[index] = true;
         }
       }
       int completedCourse = 0;
       StringBuilder sb = new StringBuilder();
       while(!bfsQueue.isEmpty()){
        int levelSize = bfsQueue.size();
        for(int index =0;index<levelSize; index++){
            int currentCourse = bfsQueue.poll();
            sb.append(currentCourse);
            completedCourse++;
            if(graph.containsKey(currentCourse)){
                List<Integer> dependingCourses = graph.get(currentCourse);
                for(int dc : dependingCourses){
                    prerequisiteForEveryCourse[dc]--;
                    if(prerequisiteForEveryCourse[dc]==0 && !visited[dc]){
                        bfsQueue.offer(dc);
                        visited[dc] = true;
                    }
                }
            }
        }
       }
       return completedCourse == totalCourses;
    }
    public static void main(String[] args){
        Solution obj = new Solution();
        int totalCourses = 6;
        int[][] prerequisites = {{1,0},{2,1},{3,2},{4,2},{5,3},{5,4}};
        obj.canFinish(totalCourses,prerequisites);
    }
}
