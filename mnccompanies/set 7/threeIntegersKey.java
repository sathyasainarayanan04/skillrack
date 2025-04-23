/*
there are 3 numbers - A , B and C. the key must be generated using the follwoing formula. key = [largest digit in the thousands place of all three numbers][largest digit in the hundreds place of all three numbers][largest digits of tens place in all three numbers][largest digit in the units place in all three nnumbers]
example 
input
3521 2452 1352
outupt
3552
  */

import java.util.Scanner;

public class KeyGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int[] digitsA = extractDigits(A);
        int[] digitsB = extractDigits(B);
        int[] digitsC = extractDigits(C);
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int maxDigit = Math.max(digitsA[i], Math.max(digitsB[i], digitsC[i]));
            key.append(maxDigit);
        }
        System.out.println(key);
    }
    private static int[] extractDigits(int num) {
        int[] digits = new int[4];
        digits[0] = (num / 1000) % 10; 
        digits[1] = (num / 100) % 10;  
        digits[2] = (num / 10) % 10;   
        digits[3] = num % 10;          
        return digits;
    }
}
