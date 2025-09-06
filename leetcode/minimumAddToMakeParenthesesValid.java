class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions=0;
        for(int index=0; index<s.length(); index++){
            char ch = s.charAt(index);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                   insertions++;
                }
                else{
                    stack.pop();
                }
            }
        }
        insertions = insertions + (stack.size());
        return insertions;
    }
}
