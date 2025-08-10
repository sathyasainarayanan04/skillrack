class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int targetLevel) 
    {
       int totalPersons = friends.length;
       Queue<Integer> bfsQueue = new LinkedList<>();
       boolean visited[] = new boolean[totalPersons];
       bfsQueue.offer(id);
       visited[id] = true;
       int currentLevel = 0;
       while(!bfsQueue.isEmpty() && currentLevel<targetLevel){
        int levelSize = bfsQueue.size();
        for(int index=0;index<levelSize;index++){
            int currentPerson = bfsQueue.poll();
            for(int frd : friends[currentPerson]){
                if(!visited[frd]){
                    visited[frd] = true;
                    bfsQueue.offer(frd);
                }
            }
        }
        currentLevel++;
       }
       List<Integer> targetLevelFriends = new ArrayList<>(bfsQueue);
       Map<String,Integer> videoFrequencyMap = new HashMap<>();
       for(int frd : targetLevelFriends){
        for(String video : watchedVideos.get(frd)){
            videoFrequencyMap.put(video,videoFrequencyMap.getOrDefault(video,0)+1);
        }
       }
       List<String> result = new ArrayList<>(videoFrequencyMap.keySet());
       result.sort((video1,video2)->{
         int compare = Integer.compare(videoFrequencyMap.get(video1),videoFrequencyMap.get(video2));
         if(compare!=0){
            return compare;
         }
         return video1.compareTo(video2);
       });
       return result;
    }
    public static void main(String[] args){
        List<List<String>> watchedVideos = Arrays.asList(
            Arrays.asList("A","B"),
            Arrays.asList("B","C"),
            Arrays.asList("A","D"),
            Arrays.asList("C","D","E"),
            Arrays.asList("E","F")
        );
        int[][] friends = {
            {2,3},{0,3},{0,4},{1,4},{2,3}
        };
        int id = 0;
        int targetLevel = 2;
        Solution object = new Solution();
        List<String> result = object.watchedVideosByFriends(watchedVideos,friends,id,targetLevel);
        System.out.println(result);
    }
}

/*
u -> number of unique videos 
f -> number of friends edges
n -> number of people 
V -> number of videos 
O(n + f)        // BFS
+ O(V)          // Collect videos
+ O(u log u)    // Sort videos

worst case time complexity - O(n + f + V + u log u)
best case time complexity - O(u+v)

space complexity :
O(n+u) 
*/
