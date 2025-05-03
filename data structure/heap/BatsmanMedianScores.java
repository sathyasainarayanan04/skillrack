/*
The program must accept the runs scored by a batsman in N matches as input. For every match m (where m = 1 to N), the program must:

Sort the runs scored till the m-th match, and

Print the output based on the following conditions:

✅ Output Conditions:
If m is odd, print the run scored in the middle match.

If m is even, print the average of the two middle match scores.

📝 Note: The runs scored must be printed with a precision up to 2 decimal places.

🔒 Boundary Conditions:
1 ≤ N ≤ 10⁵

0 ≤ Runs scored in each match ≤ 10⁵

🧾 Input Format:
The first line contains an integer N (number of matches).

The second line contains N space-separated integers (runs scored in each match).

📤 Output Format:
Print N lines. Each line contains a floating-point value — the median of the runs scored till that match, as per the conditions.

📌 Example Input/Output 1:
Input:
5
10 5 2 4 3

Output:

10.00
7.50
5.00
4.50
4.00
example 2
input
  
10
39 50 33 3 2 76 6 53 81 19
output
39.00
44.50
39.00
36.00
33.00
36.00
33.00
36.00
39.00
36.00
*/
import java.util.*;

public class BatsmanMedianScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matchCount = scanner.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int matchIndex = 0; matchIndex < matchCount; matchIndex++) {
            int runsScored = scanner.nextInt();
            System.out.println("\nMatch " + (matchIndex + 1) + ": Scored " + runsScored);

            if (maxHeap.isEmpty() || runsScored <= maxHeap.peek()) {
                maxHeap.offer(runsScored);
                System.out.println("Added to maxHeap: " + runsScored);
            } else {
                minHeap.offer(runsScored);
                System.out.println("Added to minHeap: " + runsScored);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                int moved = maxHeap.poll();
                minHeap.offer(moved);
                System.out.println("Balancing: Moved " + moved + " from maxHeap to minHeap");
            } else if (minHeap.size() > maxHeap.size()) {
                int moved = minHeap.poll();
                maxHeap.offer(moved);
                System.out.println("Balancing: Moved " + moved + " from minHeap to maxHeap");
            }

            System.out.println("maxHeap (lower half): " + maxHeap);
            System.out.println("minHeap (upper half): " + minHeap);

            double median;
            if ((matchIndex + 1) % 2 == 1) {
                median = maxHeap.peek();
            } else {
                median = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }

            System.out.printf("Median after Match %d: %.2f\n", matchIndex + 1, median);
        }

        scanner.close();
    }
}
