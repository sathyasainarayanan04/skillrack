class Solution {
    public int findPeakElement(int[] nums) {
        List<Integer> peakIndex = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int index=0 ;index<nums.length; index++){
            int num = nums[index];
            if(stack.isEmpty()){
                stack.push(num);
                peakIndex.add(index);
            }
            else if(!stack.isEmpty() && stack.peek()<num){
                stack.push(num);
                peakIndex.add(index);
            }
            else if(num>stack.peek()){
                peakIndex.remove(peakIndex.size()-1);
                peakIndex.add(index-1);
                while(!stack.isEmpty() && stack.peek()>num){
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return peakIndex.get(peakIndex.size()-1);
        }
        System.out.println(peakIndex);
        return peakIndex.size()>0?peakIndex.get(peakIndex.size()-1):0;
    }
}
