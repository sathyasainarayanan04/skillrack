class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int totalPerson = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int person = 0; person < totalPerson; person++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[totalPerson];
        for(int relation[] : richer){
            int rich = relation[0];
            int poor = relation[1];
            graph.get(rich).add(poor);
            inDegree[poor]++;
        }
        int[] answer = new int[totalPerson];
        for(int person = 0; person < totalPerson; person++){
            answer[person] = person;
        }
        Queue<Integer> bfsQueue = new LinkedList<>();
        for(int person = 0; person < totalPerson; person++){
            if(inDegree[person]==0)
               bfsQueue.offer(person);
        }
        while(!bfsQueue.isEmpty()){
            int richPerson = bfsQueue.poll();
            for(int poorPerson : graph.get(richPerson)){
                int quietLevelForRich = answer[richPerson];
                int quietLevelForPoor = answer[poorPerson];
                if(quiet[quietLevelForRich] < quiet[quietLevelForPoor]){
                    answer[poorPerson] = answer[richPerson];
                }
                inDegree[poorPerson]--;
                if(inDegree[poorPerson]==0)
                   bfsQueue.offer(poorPerson);
            }
        }
        return answer;
    }
}
/*People (n): 6 (labeled 0, 1, 2, 3, 4, 5)

richer relationships: [[1, 0], [2, 0], [3, 1], [5, 4]]
quiet values: [7, 4, 8, 3, 9, 2]

People (n): 8

richer relationships: [[1, 0], [2, 1], [3, 0], [4, 2], [6, 4], [6, 3], [5, 7]]
               0, 1, 2, 3, 4, 5, 6, 7
quiet values: [5, 9, 2, 6, 1, 8, 0, 7]

[6, 6, 6, 6, 6, 5, 6, 7]*/
