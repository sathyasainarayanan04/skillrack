/*
A set of space separated integers are passed as the input. The program must replace the alternate duplicate integer values with zero. 
Then the program must print the revised set of integers as the output. 
Boundary Condition(s): 1 <= Each integer value <= 10^5 
Input Format: The first line contains a set of integer values separated by a space. 
Output Format: The first line contains the revised set of integer values separated by a space. 
Example Input/Output 1: Input: 5 5 5 5 5 5 
Output: 5 0 5 0 5 0 
Example Input/Output 2: Input: 10 2 2 15 6 9 15 2 15 19 15 
Output: 10 2 0 15 6 9 0 2 15 19 0 
Example Input/Output 3: Input: 10 2 2 15 6 9 15 2 15 9 15 
Output: 10 2 0 15 6 9 0 2 15 0 0
*/
import java.util.*;
public class Hello {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 String[] input = sc.nextLine().split(" ");
 Map<Integer,Integer> frequencyMap = new HashMap<>();
 for(int index=0;index<input.length;index++){
 int number = Integer.parseInt(input[index]);
 frequencyMap.put(number,frequencyMap.getOrDefault(number,0
 int frequency = frequencyMap.get(number);
 if(frequency%2==0){
 System.out.print(0+" ");
 }
 else{
 System.out.print(number+" ");
 }
 }
 }
