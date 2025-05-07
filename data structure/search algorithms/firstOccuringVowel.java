/*
The program must accept a string S as the input. The program must print the first occurring 
vowel in the string S as the output. If there is no vowel in the string S then the program 
must print -1 as the output. 
Boundary Condition(s): 1 <= Length of S <= 1000 
Input Format: The first line contains the string S. Output Format: The first line contains either the first occurring vowel in the string S or -1. 
Example Input/Output 1:
Input: cricket 
Output: i 
Explanation: The vowels in the string "cricket" are i and e. Here the first occurred vowel is i.
So it is printed as the output.
Example Input/Output 2: Input: ELEGANT Output: E Example Input/Output 3: Input: dry Output: -1
*/
import java.util.Scanner;

public class FirstVowelFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine(); 
        scanner.close();
        String vowels = "aeiouAEIOU";
        boolean vowelFound = false;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                System.out.println(ch);
                vowelFound = true;
                break;
            }
        }
        if (!vowelFound) {
            System.out.println("-1");
        }
    }
}
