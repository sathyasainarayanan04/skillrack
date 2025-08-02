class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Integer> stack = new Stack<>();
       if(num.length()==1)return "0";
       StringBuilder resultString = new StringBuilder();
       for(char ch : num.toCharArray()){
        int number = ch-'0';
        while(!stack.isEmpty() && stack.peek()>number && k>0){
            stack.pop();
            k--;
        }
        stack.push(number);
       }
       while(!stack.isEmpty() && k>0){
        stack.pop();
        k--;
       }
       while(!stack.isEmpty()){
        resultString.append(stack.pop());
       }
       for(int index=0;index<resultString.length();index++){
        stack.push(resultString.charAt(index)-'0');
       }
       while(!stack.isEmpty() && stack.peek()==0){
        stack.pop();
       }
       resultString = new StringBuilder();
       while(!stack.isEmpty()){
        resultString.append(stack.pop());
       }
       return resultString.length()==0?"0":resultString.toString();
    }
}
