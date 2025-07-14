package leetcode;
import java.util.*;
public class ReorganizeString {
    public String reorganizeString(String input){
        Map<Character,Integer> frequencyMap = new HashMap<>();
        for(char ch : input.toCharArray()){
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
        (a,b)->frequencyMap.get(b)-frequencyMap.get(a)
        );
        maxHeap.addAll(frequencyMap.keySet());
        StringBuilder result = new StringBuilder();
        int maxFrequency = frequencyMap.get(maxHeap.peek());
        if(maxFrequency>(input.length()+1/2))return "";
        char PreviousCharacter = ' ';
        int PreviousCount = 0;
        while(!maxHeap.isEmpty()){
            Character current = maxHeap.poll();
            result.append(current);
            frequencyMap.put(current,frequencyMap.get(current)-1);
            if(PreviousCount != 0 && PreviousCharacter!=' '){
                maxHeap.offer(PreviousCharacter);
            }
            PreviousCharacter = current;
            PreviousCount = frequencyMap.get(PreviousCharacter);
        }
        if(result.toString().length()!=input.length())return "";
        return result.toString();
    }
    public static void main(String[] args){
        ReorganizeString obj = new ReorganizeString();
        System.out.println(obj.reorganizeString("aaabbbcccdddddd"));
    }
}
