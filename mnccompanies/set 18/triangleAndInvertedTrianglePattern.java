/*
Problem Statement:
    The program must accept an integer N as the input.
    The program must print the desired pattern of (2*N) - 1 lines as shown in the Example Input/Output section.

Boundary Condition(s):
    2 <= N <= 50

Input Format:
    The first line contains N.

Output Format:
    The first (2*N) - 1 lines contain the desired pattern as shown in the Example Input/Output section.

Example Input/Output 1:
    Input:
        4
    Output:
        1 2 3 4
        *2 3 4
        **3 4
        ***4
        **3 4
        *2 3 4
        1 2 3 4

Example Input/Output 2:
    Input:
        5
    Output:
        1 2 3 4 5
        *2 3 4 5
        **3 4 5
        ***4 5
        ****5
        ***4 5
        **3 4 5
        *2 3 4 5
        1 2 3 4 5
*/
import java.util.*;

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // First half of the pattern
        for (int index = 0; index < n; index++) {
            String answer = "";
            for (int j = index + 1; j <= n; j++) {
                answer += String.valueOf(j);
                answer += " ";
            }
            System.out.println(answer);
        }

        // Second half of the pattern
        for (int index = n - 2; index > -1; index--) {
            String answer = "";
            for (int j = 0; j < index; j++) {
                answer += "*";
            }
            for (int j = index + 1; j <= n; j++) {
                answer += String.valueOf(j);
                answer += " ";
            }
            System.out.println(answer);
        }
    }
}
