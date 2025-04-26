/*
S1 Contains S2 (Subsequence Check)
Given two string values S1 and S2, write a program to print "YES" if the characters of S2 appear in the same order in S1 (they do not have to be continuous, but the order must be maintained).
Otherwise, print "NO".

🔥 Boundary Conditions:
1 ≤ Length of S1, S2 ≤ 10⁷

📥 Input Format:
First line: A string S1

Second line: A string S2

📤 Output Format:
Print YES if S2 is a subsequence of S1, otherwise print NO.

🧩 Example 1:
Input:

nginx
Copy code
superkoolfillerandcopperkit
skillrack
Output:

objectivec
Copy code
YES
Explanation:
Characters of skillrack appear in the same order inside superkoolfillerandcopperkit.

🧩 Example 2:
Input:

nginx
Copy code
germanactor
men
Output:

objectivec
Copy code
NO
Explanation:
Characters of men do not appear in the correct order inside germanactor.

*/
import java.util.Scanner;

public class SubsequenceCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int index1 = 0, index2 = 0;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) == s2.charAt(index2)) {
                index2++;
            }
            index1++;
        }

        if (index2 == s2.length()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}
