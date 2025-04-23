/*
there are N buildings in a housing area. the program must accept N integers representing 
the number of floors in each building as the input. all the number of floors in the housing 
area occur odd number of itmes but onl one number of floors occur even number of times. 
the program must print the number of floors that occur even number of times as the output. 
if alll the floors occurs odd number of times, the program must print -1 as the output . */
import java.util.*;

public class EvenFrequencyFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of buildings: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter number of floors in each building:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Check for even frequency
        boolean found = false;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                System.out.println(entry.getKey());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}
