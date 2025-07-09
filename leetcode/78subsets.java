import java.util.*;
public class subset {
    public void generateSubsets(int[] inputArray, int index, List<Integer> currentSubset, List<List<Integer>> allSubsets){
        allSubsets.add(new ArrayList<>(currentSubset));
        for(int i=index;i<inputArray.length;i++){
            currentSubset.add(inputArray[i]);
            generateSubsets(inputArray,i+1,currentSubset,allSubsets);
            currentSubset.remove(currentSubset.size()-1);
        }
    }
    public static void main(String[] args){
        List<List<Integer>> allSubsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        int[] inputArray = {1,2,3};
        subset obj = new subset();
        obj.generateSubsets(inputArray,0,currentSubset,allSubsets);
        for(List<Integer> list : allSubsets){
            System.out.println(list+" ");
        }
    }
}
