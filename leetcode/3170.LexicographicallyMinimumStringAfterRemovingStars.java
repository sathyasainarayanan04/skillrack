package leetcode;
import java.util.*;
public class LexicographicallyMinimumStringAfterRemovingStars {
    public String clearStars(String input){
        List<List<Integer>> charListMap = new ArrayList<>();
        for(int index=0;index<26;index++){
            charListMap.add(new ArrayList<>());
        }
        char[] array = input.toCharArray();
        for(int index=0;index<input.length();index++){
            char ch = input.charAt(index);
            if(ch!='*'){
                int position = ch-'a';
                charListMap.get(position).add(index);
            }
            else{
                for(int list=0;list<26;list++){
                   List<Integer> alphaIndexList = charListMap.get(list);
                   if(alphaIndexList.size()>0){
                       int removeIndex = alphaIndexList.get(alphaIndexList.size()-1);
                       alphaIndexList.remove(alphaIndexList.size()-1);
                       array[removeIndex]='*';
                       break;
                   }
                }
            }
        }
        String str = "";
        for(char ch : array){
            if(ch!='*')str+=ch;
        }
        return str;
    }
    
    public static void main(String[] args){
        LexicographicallyMinimumStringAfterRemovingStars obj = 
                new LexicographicallyMinimumStringAfterRemovingStars();
        System.out.println(obj.clearStars("abc*d*e"));
    }
}
