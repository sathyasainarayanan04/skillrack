/*
The program must accept a string S, a character CH and an integer K as the input. The string is said to be valid only if the character CH is consecutively repeated for at most K times. 
The program must print the minimum number of characters to be removed from S to become a valid string as the output. 
Boundary Condition(s): 1 <= Length of S <= 1000 1 <= K <= Length of S
Input Format: The first line contains S, CH and K separated by a space. 
Output Format: The first line contains the minimum number of characters to be removed from S to become a valid string. 
Example Input/Output 1: Input: abccccddeee c 2 Output: 2 
Explanation: Here 4 consecutive c's have occurred in the string "abccccddeee". 
The possible valid string values are "abddeee" -> 4 c's removed "abcddeee" -> 3 c's removed "abccddeee" -> 2 c's removed So the minimum number of c's to be removed from S is 2. Hence the output is 2 
Example Input/Output 2: Input: BAAABBBBBCCBBBBDBBB B 3 Output: 3
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
    Scanner sc = new Scanner(System.in);
    String input[] = sc.nextLine().split(" ");
    String mainString = input[0];
    char ch = input[1].charAt(0);
    int n = Integer.parseInt(input[2]);
    List<Integer> list = new ArrayList<>();
    int length = 0;
    for(int index=0;index<mainString.length();index++){
        if(index>1 && mainString.charAt(index)==ch && mainString.charAt(index-1)==ch){
            length++;
        }
        else if(mainString.charAt(index)==ch){
            length++;
        }
        else if(index>0 && mainString.charAt(index-1)==ch && mainString.charAt(index)!=ch){
            list.add(length);
            length=0;
        }
    }
    if(length>0){
        list.add(length);
    }
    int count = 0;
    for(int index=0;index<list.size();index++){
        int size = list.get(index);
        if(size>n){
            count = count + Math.abs(n-size);
        }
    }
    System.out.println(count);
	}
}
