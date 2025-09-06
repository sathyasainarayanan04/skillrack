import java.util.Stack;
class Solution {
    public int minInsertions(String s) {
       Stack<Character> stack = new Stack<>();
       int insertions = 0;
       for(int index=0; index< s.length(); index++){
        char ch = s.charAt(index);
        if(ch=='('){
            stack.push(ch);
        }
        else{
            if(index+1 < s.length() && s.charAt(index+1) == ')'){
                if(stack.isEmpty()){
                  insertions++;
                }
                else{
                    stack.pop();
                }
                index++;
            }
            else{
                if(stack.isEmpty()){
                    insertions+=2;
                }
                else{
                    insertions++;
                    stack.pop();
                }
            }
        }
       }
       insertions += (2*stack.size());
       return insertions;
    }
}
/*

-> Cases to Handle

If character is '('
→ Push it into the stack (waiting for two )).

If character is ')' and the next one is also ')'

If stack not empty → pop '(' (we matched one).

If stack empty → need an extra '(' before → insertions++

Skip the next ')' (since we processed the pair).

If character is single ')' (not followed by another ))

If stack not empty → pop '(', but since we only saw one ), insert one more ')' → insertions++

If stack empty → no '(' available, so we need "(" + ")" → insertions += 2

End of string

Each remaining '(' in stack needs "))"

Add 2 × stack size to insertions.

  */
