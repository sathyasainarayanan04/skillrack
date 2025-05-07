/*
The program must accept N integers as the input. 
The program must print the number of occurrences of the last 
integer among the N integers as the output. 
Boundary Condition(s): 1 <= N <= 100 -10^8 <= Each integer value <= 10^8 
Input Format: The first line contains the value of N. The second line contains N integers 
separated by space(s). 
Output Format: The first line contains the number of occurrences of the last integer among
the N integers.
Example Input/Output 1:
Input: 5 12 14 56 14 14 
Output: 3 
Explanation: The last integer is 14. Here 14 has occurred 3 times. So 3 is printed. 
Example Input/Output 2: Input: 8 6 -10 -5 10 -6 5 6 -7 Output: 1
*/

import java.util.Scanner;
public class LastIntegerOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();         
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();
        int lastNumber = numbers[N - 1];  
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (numbers[i] == lastNumber) {
                count++;
            }
        }
        System.out.println(count);         
    }
}
