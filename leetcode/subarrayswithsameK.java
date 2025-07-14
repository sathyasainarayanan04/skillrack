
package leetcode;
import java.util.*;
public class NumberOfSubArraysWithLCMEqualToK {
    public int GCD(int a, int b){
        while(b!=0){
            int remainder = a%b;
            a = b;
            b = remainder;
        }
        return a;
    }
    public int LCM(int a, int b){
        return (a*b)/GCD(a,b);
    }
    public List<List<Integer>> allPossibleSubArraysLCMK(int[] array, int k){
       List<List<Integer>> result = new ArrayList<>();
       for(int index=0;index<array.length;index++){
           List<Integer> subarray = new ArrayList<>();
           int currentLCM = array[index];
           subarray.add(currentLCM);
           if(currentLCM==k){
               result.add(new ArrayList<>(subarray));
           }
           for(int jindex=index+1;jindex<array.length;jindex++){
                currentLCM = LCM(array[index],array[jindex]);
                if(currentLCM>k)break;
                subarray.add(array[jindex]);
                if(currentLCM==k){
                    result.add(new ArrayList<>(subarray));
                }
           }
       }
       return result;
    }
    public static void main(String[] args){
        int[] array = {3,6,2,7,1};
        int k = 6;
        NumberOfSubArraysWithLCMEqualToK obj = new NumberOfSubArraysWithLCMEqualToK();
        List<List<Integer>> result = obj.allPossibleSubArraysLCMK(array,k);
        for(List<Integer> l : result){
            System.out.println(l);
        }
    }
}
