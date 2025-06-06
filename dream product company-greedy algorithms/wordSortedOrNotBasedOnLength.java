/*
The program must accept a string S with space as the input. The program must YES if all the words in S are sorted in ascending order based on their length. Else the program must print NO as the output. Boundary Condition(s): 1 <= Length of S <= 1000 Input Format: The first line contains the string S. Output Format: The first line contains either YES or NO. Example Input/Output 1: Input: The moon looks beautiful Output: YES Explanation: The length of the first word is 3. The length of the second word is 4. The length of the third word is 5. The length of the fourth word is 9. 
  Here the lengths are in ascending order (3 4 5 9). So YES is printed as the output. Example Input/Output 2: Input: I am a Doctor Output: NO
  */
import java.util.*;
public class Hello {
 public static void main(String[] args) {
 //Your Code Here
 Scanner sc = new Scanner(System.in);
 String[] input = sc.nextLine().split(" ");
 int[] array = new int[input.length];
 boolean flag = true;
 int maximum = 0;
 for(int index=0;index<input.length;index++){
 array[index]=input[index].length();
 if(maximum<=input[index].length()){
 maximum=input[index].length();
 }
 else{
 flag=false;
   }
 }
 System.out.println(flag?"YES":"NO");
 }
}
