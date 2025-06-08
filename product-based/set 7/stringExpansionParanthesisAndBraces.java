/*
A string is passed as the input in which alphabets that are to be repeated are inside () and the count C to repeat is inside {}. 
A negative value of C means the case is to be toggled. The program must print the output based on the Example Input/Output section.
Boundary Condition(s): 3 <= Length of S <= 100
Input Format: The first line contains S.
Output Format: The first line contains the expanded string based on the given conditions. 
Example Input/Output 1: 
Input: (z){-2}eal 
Output: ZZeal 
Explanation: z is toggled and repeated twice giving ZZ Then we have eal.
Example Input/Output 2:
Input: ((X){-2}(y){3}(z)){2} 
Output: xxyyyzxxyyyz 
Explanation: (X){-2} gives xx (y){3} gives yyy (z) gives z So now (xxyyyz){2} is to be repeated twice giving xxyyyzxxyyyz 
Example Input/Output 3:
Input: ((X){-2}(y){3}(z)){-2}
Output: XXYYYZXXYYYZ 
Example Input/Output 4:
Input: ((Abc){-3}def(x){5}mn){2} 
Output: aBCaBCaBCdefxxxxxmnaBCaBCaBCdefxxxxxmn
*/
import java.util.*;
public class stringExpansionParathesisAndBraces {
    public static String toggleCase(String string){
        StringBuilder sb = new StringBuilder();
        for(int index=0;index<string.length();index++){
            char ch = string.charAt(index);
            if(Character.isUpperCase(ch))
                sb.append(Character.toLowerCase(ch));
            else if(Character.isLowerCase(ch))
                sb.append(Character.toUpperCase(ch));
            else 
                sb.append(ch);
        }
        return sb.toString();
    }
    public static String process(String string){
        Stack<String> stack = new Stack<>();
        int index=0;
        while(index<string.length()){
            char ch = string.charAt(index);
            if(ch==')'){
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    sb.insert(0,stack.pop());
                }
                stack.pop();
                index++;
                int repeat = 1;
                if(index<string.length() && string.charAt(index)=='{'){
                    index++;
                    int start = index;
                    while(string.charAt(index)!='}')index++;
                    repeat = Integer.parseInt(string.substring(start,index));
                    index++;
                }
                String str = sb.toString();
                if(repeat<0){
                    str = toggleCase(str);
                    repeat = -repeat;
                }
                for(int k=0;k<repeat;k++)stack.push(str);
            }
            else{
                stack.push(String.valueOf(ch));
                index++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(String str : stack){
            result.append(str);
        }
        return result.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(process(input));
    }
}
