import java.util.*;
public class HotelQueueManager{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int index=0;index<n;index++){
            int id = sc.nextInt();
            String s = sc.next();
            if(s=="N"){
                queue.offer(id);
            }
            else if(s=="D"){
                Queue<Integer> temporaryQueue = new LinkedList<>();
                while(queue.peek()==id){
                    int current = queue.poll();
                    temporaryQueue.offer(current);
                }
                queue.poll();
                while(!temporaryQueue.isEmpty()){
                    queue.offer(temporaryQueue.poll());
                }
            }
        }
        System.out.println(queue.isEmpty()?-1:((LinkedList<Integer>)queue).getLast());
    }
}
/*
A queue is maintained in a self serviced hotel.
  Customers wait in the queue either to order their food or to get their food. If a customer has ordered the food, then the customer must go back to the last position in the queue. If the food ordered by a customer C is ready then the customers standing in front of C will go to the last position of the queue until the customer C reaches the front of the queue to get his food. Each customer orders different food so their waiting time values are also different. Series of N event details containing the customer id and event type are passed as the input to the program. The event type is denoted by the character CH. If the character CH is N, a new customer has joined the queue to place his order. if the character is D, then the order is ready to be delivered to the customer. The program must print the customer id of the last person standing in the queue after N events. If there is no person standing in the queue after N events then the program must print -1 as the output. Boundary Condition(s): 1 <= N <= 1000 1 <= Value of each customer id <= 10^8 Input Format: The first line contains the value of N. The next N lines contain the customer id followed by the event type separated by a space. Output Format: The first line contains the customer id of the last person standing in the queue after N events or -1. Example Input/Output 1: Input: 7 1 N 2 N 2 D 3 N 4 N 5 N 4 D Output: 3 Explanation: The 1st event is 1 N. The customer having the id as 1 has joined in the queue. Now the queue becomes 1. The 2nd event is 2 N. The customer having the id as 2 has joined in the queue. Now the queue becomes 1 2. The 3rd event is 2 D. The food for the customer id 2 is ready. So the customer standing in front of the customer id 2 will go to the last position of the queue until the customer id 2 reaches the front of the queue. Then he collects his food and leaves from the queue. Now the queue becomes 1. The 4th event is 3 N. The customer having the id as 3 has joined in the queue. Now the queue becomes 1 3. The 5th event is 4 N. The customer having the id as 4 has joined in the queue. Now the queue becomes 1 3 4. The 6th event is 5 N. The customer having the id as 5 has joined in the queue. Now queue becomes 1 3 4 5. The 7th event is 4 D. The food for the customer id 4 is ready. So the customers standing in front of the customer id 4 will go to the last position of the queue until the customer id 4 reaches the front of the queue. Then he collects his food and leaves from the queue. Now the queue becomes 5 1 3. Now the customer id of the last person in the queue is 3. Hence the output is 3. Example Input/Output 2: Input: 10 5 N 3 N 3 D 4 N 1 N 4 D 5 D 2 N 1 D 2 D Output: -1
  */
