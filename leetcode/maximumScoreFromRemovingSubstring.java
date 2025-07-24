class Solution {
    public int getScore(String s, int x, int y, char firstLetter, char secondLetter){
        Stack<Character> stack = new Stack<>();
        int point = 0;
        for(int index=0;index<s.length();index++){
                char ch = s.charAt(index);
                if(ch==firstLetter && !stack.isEmpty() && stack.peek()==secondLetter){
                   point+=y;
                   System.out.println(point+" added");
                   stack.pop();
                }
                else{
                    stack.push(ch);
                }
        }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            sb = sb.reverse();
            Stack<Character> stack2 = new Stack<>();
            for(int index=0;index<sb.length();index++){
               char ch = sb.charAt(index);
                if(ch==secondLetter && !stack2.isEmpty() && stack2.peek()==firstLetter){
                   point+=x;
                   System.out.println(point+" added");
                   stack2.pop();
                }
                else{
                   stack2.push(ch);
                }
            }
            return point;
    }
    public int maximumGain(String s, int x, int y) {
        if(x<y)return getScore(s,x,y,'a','b');
        return getScore(s,y,x,'b','a');
    }
}
