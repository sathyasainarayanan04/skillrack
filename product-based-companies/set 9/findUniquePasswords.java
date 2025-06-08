/*
The program must accept N string values representing the passwords of N employees as the input. 
Each password contains only lowercase letters. All N passwords are of equal length. 
The program must print the number of unique passwords among the given N passwords as the output.
Two passwords P1 and P2 are same if P2 can be obtained by swapping the Xth character with the Yth character in P1,
where (X + Y) % 2 = 0. The swapping can be done repeatedly. 
Boundary Condition(s): 1 <= N <= 100 1 <= Length of each password <= 50 
Input Format: The first line contains N. The next N lines, each contains a string value representing the password of an employee.
Output Format: The first line contains an integer representing the number of unique passwords. 
Example Input/Output 1: 
Input: 2 pqrs rspq 
Output: 1 
Explanation: The password "pqrs" can be obtained by swapping the characters in "rspq" as given below. 
1st swap (1, 3): rspq -> psrq 2nd swap (2, 4): psrq -> pqrs 
Example Input/Output 2: Input: 3 abcde badce ebcda 
Output: 2 Example Input/Output 3: Input: 6 abcxyz axczyb cxyzab azcbyx axczyb yxczab Output: 1
*/
import java.util.*;
public static String getCanonicalForm(String password) {
        List<Character> evenChars = new ArrayList<>();
        List<Character> oddChars = new ArrayList<>();
        for (int i = 0; i < password.length(); i++) {
            if (i % 2 == 0) {
                evenChars.add(password.charAt(i));
            } else {
                oddChars.add(password.charAt(i));
            }
        }
        Collections.sort(evenChars);
        Collections.sort(oddChars);
        StringBuilder key = new StringBuilder();
        for (char ch : evenChars) key.append(ch);
        key.append('|');
        for (char ch : oddChars) key.append(ch);
        return key.toString();
    }
public class UniquePasswords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        sc.nextLine(); 
        Set<String> uniqueKeys = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String password = sc.nextLine();
            uniqueKeys.add(getCanonicalForm(password));
        }
        System.out.println(uniqueKeys.size());
    }
    
}
