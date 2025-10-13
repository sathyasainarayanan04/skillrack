class Solution {
    public int minSwapsCouples(int[] row) {
        int totalSwaps = 0;
        int totalSeats = row.length;
        Map<Integer, Integer> seatMap = new HashMap<>();
        for(int index=0; index<totalSeats; index++){
            seatMap.put(row[index], index);
        }
        for(int index=0; index<totalSeats; index+=2){
            int firstPerson = row[index];
            int secondPerson = row[index+1];
            int expectedPerson = firstPerson ^ 1;
            if(secondPerson!=expectedPerson){
                totalSwaps++;
                int partnerSeatIndex = seatMap.get(expectedPerson);
                row[partnerSeatIndex] = secondPerson;
                row[index+1] = expectedPerson;
                seatMap.put(secondPerson,partnerSeatIndex);
                seatMap.put(expectedPerson,index+1);
            }
        }
        return totalSwaps;
    }
}
