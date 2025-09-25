class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> lastSeenIndexMap = new HashMap<>();
        int minimumLength = Integer.MAX_VALUE;
        for(int currentIndex =0; currentIndex < cards.length; currentIndex++){
            int currentCard = cards[currentIndex];
            if(lastSeenIndexMap.containsKey(currentCard)){
                int previousIndex = lastSeenIndexMap.get(currentCard);
                int currentLength = currentIndex - previousIndex + 1;
                minimumLength = Math.min(minimumLength, currentLength);
            }
            lastSeenIndexMap.put(currentCard, currentIndex);
        }
        return minimumLength == Integer.MAX_VALUE ? -1 : minimumLength;
    }
}
