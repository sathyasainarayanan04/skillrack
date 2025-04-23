import java.util.Scanner;

public class MinimumJumpsToZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the step number
        int N = sc.nextInt();
        int jumps = 0;

        // Keep jumping until we reach step 0
        while (N > 0) {
            if (N % 2 == 0) {
                N = N / 2;
            } else {
                N = N - 1;
            }
            jumps++;
        }

        // Output the number of jumps
        System.out.println(jumps);
    }
}
