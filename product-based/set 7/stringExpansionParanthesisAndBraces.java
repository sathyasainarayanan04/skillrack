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
