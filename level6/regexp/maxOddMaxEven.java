/*
N string values are passed as the input. Numerical values are embedded within the string values. 
For each numerical value, the program must print the longest odd and even number that can be formed (from the beginning of that specific numerical value). 
Boundary Condition(s): 1 <= N <= 100 1 <= Length of String Value <= 10^5 Input Format: The first line contains the value of N. The next N lines contain the N string values.
Output Format: N lines contain the longest odd and even numbers separated by a space.
Example Input/Output 1: Input: 2 tjdrl21583zp422m2824 69248eul1fda72545248 German8y800 Output: 21583 2158 422 2824 69 69248 1 72545 72545248 8 800
*/
import java.math.BigInteger;
import java.util.*;

public class Hello {
    public static boolean isOdd(BigInteger number) {
        return number.mod(BigInteger.TWO).equals(BigInteger.ONE);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            StringBuilder number = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (Character.isDigit(ch)) {
                    number.append(ch);
                    if (j == input.length() - 1 || !Character.isDigit(input.charAt(j + 1))) {
                        String numStr = number.toString();
                        boolean oddFlag = false;
                        boolean evenFlag = false;
                        String odd = "";
                        String even = "";

                        for (int digit = numStr.length(); digit > 0; digit--) {
                            BigInteger subNum = new BigInteger(numStr.substring(0, digit));
                            if (isOdd(subNum) && !oddFlag) {
                                odd = numStr.substring(0, digit);
                                oddFlag = true;
                            } else if (!isOdd(subNum) && !evenFlag) {
                                even = numStr.substring(0, digit);
                                evenFlag = true;
                            }
                        }

                        if (!odd.isEmpty()) {
                            System.out.print(odd + " ");
                        }
                        if (!even.isEmpty()) {
                            System.out.print(even + " ");
                        }

                        number = new StringBuilder();
                    }
                }
            }
        }
        System.out.println();
    }
}
