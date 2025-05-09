/*
Problem Statement:
    The program must accept an integer N as the input.
    The program must find the triangular number T for the given integer N.
    A triangular number is the sum of all the numbers from 1 to N.
    Then the program must print the sum of all the factors of T except T as the output.

Boundary Condition(s):
    1 <= N <= 1000

Input Format:
    The first line contains N.

Output Format:
    The first line contains an integer value representing the sum of all the factors of T except T.

Example Input/Output 1:
    Input:
        5
    Output:
        9

    Explanation:
        Here the value of N is 5.
        The sum of integers from 1 to 5 is 15, which is a triangular number.
        The sum of factors of 15 (except 15) is 9 (1 + 3 + 5).
        So 9 is printed as the output.

Example Input/Output 2:
    Input:
        12
    Output:
        90

*/
import java.util.*;

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long sum = 0;
        for (int index = 1; index <= N; index++) {
            sum += index; 
        }

        long factorSum = 0;
        for (long index = 1; index < sum; index++) {
            if (sum % index == 0) {
                factorSum += index; 
            }
        }

        System.out.println(factorSum!=0?factorSum:1);
    }
}
