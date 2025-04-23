/*the program must accept a string S as the input. the string s contains alphabets and digits. the program must reverse hte string in such a way that the postions of digits in the string are left unaltered. then the program must print the revised string S as the output. 
example input 1
c102mputer3
output
r1e2tupmoc3
example 2
innput
Bot7tle98
output
elt7toB98
provide java implementaiton for it /*
import java.util.*;

public class ReverseAlphabetsPreserveDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> letters = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                letters.push(ch);
            }
        }
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                result.append(ch);
            } else {
                result.append(letters.pop());
            }
        }

        System.out.println(result.toString());
    }
}
