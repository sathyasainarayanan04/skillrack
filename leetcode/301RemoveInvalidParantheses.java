class Solution {
    private boolean isBalanced(String expression){
        int openCount = 0;
        for(char ch : expression.toCharArray()){
            if(ch=='(')
            openCount++;
            else if(ch==')')
            openCount--;
            if(openCount<0)return false;
        }
        if(openCount==0)return true;
        return false;
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> validExpressions = new ArrayList<>();
        if(s == null) return validExpressions;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        boolean flag = false;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i =0;i < levelSize; i++){
                String current = queue.poll();
                if(isBalanced(current)){
                    validExpressions.add(current);
                    flag = true;
                }
                if(!flag){
                for(int index =0; index< current.length(); index++){
                    char currentChar = current.charAt(index);
                    if(currentChar != ')' && currentChar!='(') continue;
                    String newString = current.substring(0,index) + current.substring(index+1);
                    if(!visited.contains(newString)){
                        queue.add(newString);
                        visited.add(newString);
                    }
                }
                }
            }
        }
        if(validExpressions.size()==0) validExpressions.add("");
        return validExpressions;
    }
}
