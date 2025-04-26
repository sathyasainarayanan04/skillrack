//the program must accept a string s as the input. the program msut print only the most repeated characters
//in the string s as the output. if more thna one character is repeated maximum nnumber of times,
 // then the character must be printed in the order of their occurrence as the output. 
  //if there is no repeated characters in s, then the program must print s as the output
//
import java.util.*;

public class MostRepeatedCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] freq = new int[256]; // ASCII
        
        // Count frequency
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        
        // Find max frequency
        int maxFreq = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
            }
        }
        
        // If no character repeated, print 'S'
        if (maxFreq == 1) {
            System.out.println("S");
            return;
        }
        
        // Print characters in original order if they have max frequency
        for (char ch : s.toCharArray()) {
            if (freq[ch] == maxFreq) {
                System.out.print(ch);
            }
        }
    }
}
