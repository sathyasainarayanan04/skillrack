class Solution {
    public int[] corpFlightBookings(int[][] bookings, int numberOfFlights) {
        int[] diffArray = new int[numberOfFlights];
        for(int[] booking : bookings){
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            diffArray[first-1] += seats;
            if(last < numberOfFlights){
                diffArray[last]-= seats;
            }
        }
        for(int index =0; index < numberOfFlights; index++){
            System.out.print(diffArray[index]+" ");
        }
        int prefixSum = 0;
        int[] result = new int[numberOfFlights];
        for(int index = 0; index < numberOfFlights; index++){
            prefixSum+=diffArray[index];
            result[index] = prefixSum;
        }
        return result;
    }
}
