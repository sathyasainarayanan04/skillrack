package leetcode;
import java.util.*;
class Solution {
    static class CarFleet{
        int currentPosition;
        int remainingDistance;
        int speed;
        double time;
        public CarFleet(int currentPosition, int remainingDistance, int speed, double time){
            this.currentPosition = currentPosition;
            this.remainingDistance = remainingDistance;
            this.speed = speed;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int[] distanceToTarget = new int[position.length];
        for(int index=0;index<position.length;index++){
            int distance = target - position[index];
            distanceToTarget[index] = distance;
        } 
        double[] time = new double[position.length];
        for(int index=0;index<position.length;index++){
            double t = (double)distanceToTarget[index]/speed[index];
            time[index] = t;
        }
        List<CarFleet> fleetList = new ArrayList<>();
        for(int index=0;index<position.length;index++){
            CarFleet obj = new CarFleet(position[index],distanceToTarget[index],speed[index],time[index]);
            fleetList.add(obj);
        }
        System.out.println("currentPosition "+"\t"+"remainingDistance"+"\t"+"speed"+"\t"+"time");
        Collections.sort(fleetList,(a,b)->b.currentPosition-a.currentPosition);
        int fleetCount = 0;
        double prevMinimumFleet=0;
        for(int index=0;index<fleetList.size();index++){
            CarFleet obj = fleetList.get(index);
            System.out.println(obj.currentPosition+"\t"+ obj.remainingDistance+"\t"+obj.speed+" \t"+obj.time);
            if(index==0){
                fleetCount++;
                prevMinimumFleet = obj.time;
            }
            else{
                if(obj.time>prevMinimumFleet){
                    fleetCount++;
                    prevMinimumFleet = obj.time;
                }
            }
        }
        
        return fleetCount;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] position = {6, 2, 17, 11, 14};
        int speed[] = {3, 2,  1,  2,  1};
        System.out.println("fleetCount: "+sol.carFleet(20,position,speed));
    }
}
