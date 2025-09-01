class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for(int index=0;index<s.length(); index++){
            char ch = s.charAt(index);
            if(ch=='('){
                stack.push("(");
            }
            else{
                int innerScore = 0;
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    innerScore += Integer.parseInt(stack.pop());
                }
                stack.pop();
                if(innerScore==0){
                    stack.push("1");
                }
                else{
                    stack.push(String.valueOf(2*innerScore));
                }
            }
        }
        int totalScore = 0;
        while(!stack.isEmpty()){
            totalScore += Integer.parseInt(stack.pop());
        }
        return totalScore;
    }
}
