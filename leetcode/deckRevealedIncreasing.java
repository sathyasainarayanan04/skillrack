class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int deckLength = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        for(int index=0; index< deckLength; index++){
            queue.offer(index);
        }
        Arrays.sort(deck);
        int[] ans = new int[deckLength];
        for(int index=0; index<deckLength; index++){
            int number = deck[index];
            int ansIndex = queue.poll();
            ans[ansIndex] = number;
            if(!queue.isEmpty()){
                queue.offer(queue.poll());
            }
        }
        return ans;
    }
}
