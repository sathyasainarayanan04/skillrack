
class Solution {
    
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> tripEvents = new ArrayList<>();
        int numberOfTrips = trips.length;
        for(int index = 0;index<numberOfTrips;index++){
            int passengerCount = trips[index][0];
            int pickUpLocation = trips[index][1];
            int dropLocation = trips[index][2];
            tripEvents.add(new int[]{pickUpLocation,1,passengerCount});
            tripEvents.add(new int[]{dropLocation,0,passengerCount});
        }
        Collections.sort(tripEvents,(eventA,eventB)->{
            if(eventA[0]!=eventB[0])return eventA[0]-eventB[0];
            else if(eventA[1]!=eventB[1])return eventA[1]-eventB[1];
            return eventA[2]-eventB[2];
        });
        int currentPassengers = 0;
        for(int[] event : tripEvents){
            int location = event[0];
            int eventType = event[1];
            int passengerChange = event[2];
            if(eventType==1){
                currentPassengers+=passengerChange;
                if(currentPassengers>capacity)return false;}
                else
                currentPassengers-=passengerChange;
            }
             return true;
        }
       
    }
