/*

ABC is a lawyer and is given the number of visitors at her office on N consecutive days. The number of visitors on the x-th day is Vx. 
A day is record breaking if it satisfies both of the following conditions: 
- The number of visitors on the day is strictly larger than the number of visitors on each of the previous days.
- Either it is the last day, or the number of visitors on the day is strictly larger than the number of visitors on the following day.
The program must print the number of record breaking days as the output. Note: The very first day could be a record breaking day. 
Boundary Condition(s): 1 <= T <= 100 1 <= N <= 2*10^5 0 <= Vx <= 2*10^5 
Input Format: The first line of the input has the number of test cases T. 
T test cases follow as given below. 
-Each test case begins with a line containing the integer N. 
-The second line contains N integers. 
The x-th integer is Vx. Output Format: For each test case, one line containing Case #ctr: RBC, where ctr is the test case number (starting from 1) 
and RBC is the number of record breaking days. 
Example Input/Output 1: Input: 4 8 1 2 0 7 2 0 2 0 6 4 8 15 16 23 42 9 3 1 4 1 5 9 2 6 5 6 9 9 9 9 9 9 Output: Case #1: 2 Case #2: 1 Case #3: 3 Case #4: 0 
Explanation: In test Case #1, the record breaking days are 2 and 7. In test Case #2, only the last day is a record breaking day. In test Case #3, the first, the third, and the sixth days are record breaking days. 
In test Case #4, there is no record breaking day. Example Input/Output 2: Input: 3 2 8 7 6 0 6 8 7 4 5 3 0 2 7 Output: Case #1: 1 Case #2: 1 Case #3: 1
*/
import java.util.*;
class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        for (int test = 1; test <= testCases; test++) {
            int numberOfDays = Integer.parseInt(sc.nextLine());
            String[] tokens = sc.nextLine().split(" ");
            int[] array = new int[numberOfDays];
            for (int i = 0; i < numberOfDays; i++) {
                array[i] = Integer.parseInt(tokens[i]);
            }
            int maxSoFar = -1;
            int count = 0;
            for (int i = 0; i < numberOfDays; i++) {
                boolean isGreaterThanPrev = array[i] > maxSoFar;
                boolean isGreaterThanNext = (i == numberOfDays - 1) || (array[i] > array[i + 1]);
                if (isGreaterThanPrev && isGreaterThanNext) {
                    count++;
                }
                maxSoFar = Math.max(maxSoFar, array[i]);
            }
            System.out.println("Case #" + test + ": " + count);
        }
    }
}
