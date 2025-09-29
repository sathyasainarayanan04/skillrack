class Solution {
    static class Friend{
        int arrival;
        int departure;
        int frdId;
        public Friend(int arrival, int departure, int frdId){
            this.arrival = arrival;
            this.departure = departure;
            this.frdId = frdId;
        }
    }
    static class OccupiedChair{
        int departure;
        int chairIndex;
        public OccupiedChair(int departure, int chairIndex){
            this.departure = departure;
            this.chairIndex = chairIndex;
        }
    }
    public int smallestChair(int[][] times, int targetFriend) {
        int numberOfFriends = times.length;
        Friend[] friends = new Friend[numberOfFriends];
        for(int chairIdx =0; chairIdx < numberOfFriends; chairIdx++){
            friends[chairIdx] = new Friend(times[chairIdx][0], times[chairIdx][1], chairIdx);
        }
        Arrays.sort(friends, (a,b)->Integer.compare(a.arrival, b.arrival));
        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        for(int chairIdx =0; chairIdx < numberOfFriends; chairIdx++){
            freeChairs.offer(chairIdx);
        }
        PriorityQueue<OccupiedChair> occupied = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.departure, b.departure)
        );
        for(Friend frd : friends){
            while(!occupied.isEmpty() && occupied.peek().departure <= frd.arrival){
               freeChairs.offer(occupied.poll().chairIndex);
            }
            int chairIdx = freeChairs.poll();
            if(frd.frdId == targetFriend)return chairIdx;
            occupied.offer(new OccupiedChair(frd.departure, chairIdx));
        }
        return 0;
    }
}
