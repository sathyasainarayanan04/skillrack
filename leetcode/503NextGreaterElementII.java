class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nextGreaterElementArray = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int index =2*nums.length-1;index>=0;index--){
           while(!stack.isEmpty() && stack.peek()<=nums[index%nums.length]){
            stack.pop();
           }
           if(!stack.isEmpty()){
            nextGreaterElementArray[index %nums.length]=stack.peek();
           }
           else{
            nextGreaterElementArray[index % nums.length]=-1;
           }
           stack.push(nums[index%nums.length]);
        }
        return nextGreaterElementArray;
    }
}
