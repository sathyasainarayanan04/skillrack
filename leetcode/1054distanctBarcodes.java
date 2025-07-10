
package leetcode;
import java.util.*;
public class DistantBarCodes {
    public void updateFrequency(Map<Integer,Integer> frequencyMap, int key, PriorityQueue<Integer> maxHeap){
        if(frequencyMap.get(key)==1)
            frequencyMap.remove(key);
        else{
            int value = frequencyMap.get(key);
            frequencyMap.put(key, value-1);
            maxHeap.offer(key);
        }
    }
    public int[] rearrangeBarCodes(int[] barcodes){
        int length = barcodes.length;
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int index=0;index<length;index++){
            int value = barcodes[index];
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0)+1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        (a,b)->Integer.compare(frequencyMap.get(b),frequencyMap.get(a)));
        maxHeap.addAll(frequencyMap.keySet());
        int index = 0;
        int[] rearranged = new int[length];
        while(!maxHeap.isEmpty()){
            int first = maxHeap.poll();
            rearranged[index++]=first;
            if(maxHeap.isEmpty())break;
            int second = maxHeap.poll();
            rearranged[index++]=second;
            updateFrequency(frequencyMap,first,maxHeap);
            updateFrequency(frequencyMap,second,maxHeap);
        }
        return rearranged;
    }
    public static void main(String[] args){
        int[] barcodes = {1,1,1,2,2,2};
        DistantBarCodes obj = new DistantBarCodes();
        int[] result = obj.rearrangeBarCodes(barcodes);
        for(int val : result){
            System.out.print(val+" ");
        }
    }
}
