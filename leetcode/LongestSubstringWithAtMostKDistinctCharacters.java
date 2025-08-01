import java.util.*;
import java.lang.*;
import java.io.*;

class LongestSubstringWithAtmostKDistinctCharacters
{   public static int function(String input, int k){
    int leftIndex = 0;
    Map<Character,Integer> hashMap = new HashMap<>();
    int maxLength = 0;
    for(int rightIndex =0;rightIndex<input.length();rightIndex++){
        char ch = input.charAt(rightIndex);
        hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        while(hashMap.size()>k && leftIndex<=rightIndex){
            hashMap.put(input.charAt(leftIndex),hashMap.get(input.charAt(leftIndex))-1);
            if(hashMap.get(input.charAt(leftIndex))==0){
                hashMap.remove(input.charAt(leftIndex));
            }
            leftIndex++;
        }
        maxLength = Math.max(maxLength,rightIndex-leftIndex+1);
    }
    return maxLength;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
    System.out.println(function("aaabbccd",2));
	}
}
