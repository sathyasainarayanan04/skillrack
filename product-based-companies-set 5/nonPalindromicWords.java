/*
A string with one or more words is passed as the input. The program must print only the words which are not palindromes.
Print -1 if all the words in the string are palindromes. 
Boundary Condition(s): 1 <= N, Length of S <= 1000 
Input Format: The first line contains S. 
Output Format: The first line contains the words which are not palindromes separated by a space. 
Example Input/Output 1: 
Input: Today madam came to the class 
Output: Today came to the class 
Example Input/Output 2: Input: malayalam ere Output: -1
*/
import java.util.*;
public class Hello{
public static boolean Palindromic(String word){
String reverseWord = "";
  for(int index=word.length()-1;index>-1;index--){
   reverseWord+=word.charAt(index);
  }
  if(reverseWord.equals(word)) return true;
  return false;
}
  public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
    List<String> inputString = new ArrayList<>();
    while(sc.hasNext()){
    String word = sc.next();
      if(!Palindromic(word)) inputString.add(word);
    }
    if(inputString.size()>0){
    for(int index=0;index<inputString.size();index++){
    System.out.print(inputString.get(index));
    }
    }
    else{
    System.out.println("-1");
    }
  }
}
