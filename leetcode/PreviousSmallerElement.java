
package leetcode;
import java.util.*;
public class PreviousSmallerElement {
    public static void main(String[] args){
        int[] array = {4,5,2,10,8};
        Stack<Integer> stack = new Stack<>();
        int[] PreviousSmallerElement = new int[array.length];
        stack.push(array[0]);
        PreviousSmallerElement[0]=-1;
        for(int index=1;index<array.length;index++){
            while(!stack.isEmpty() && stack.peek()>=array[index]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                PreviousSmallerElement[index]=stack.peek();
            }
            else{
                PreviousSmallerElement[index]=-1;
            }
            stack.push(array[index]);
        }
        for(int index=0;index<array.length;index++){
            System.out.print(PreviousSmallerElement[index]+" ");
        }
    }
}
