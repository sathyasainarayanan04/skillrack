/*the placement season has begun in a college. there are N number of students waiting outside an interview room in a line. it is given that a person who goes in first has a higher chances of getting selected.
each student has a number associated with them known as the problem solving capability. the higher the capability, the higher the chances of selection. now, each student wants to know the number of students ahead of him/her who have more PSC than him/her. the program must print this number for each student.. 
example input
5
6 7 1 4 11
output
0 0 2 2 0
example 2
input
6
14 9 9 9 9 9
output
0 1 1 1 1 1*/
import java.util.*;
public class PSCComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] psc = new int[n];
        for (int i = 0; i < n; i++) {
            psc[i] = sc.nextInt();
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (psc[j] > psc[i]) {
                    count++;
                }
            }
            result[i] = count;
        }
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
