class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] array = new char[s.length()];
        long suffix = 0;
        char[] alphabets = new char[26];
        int a = 0;
        for(char ch = 'a'; ch <='z'; ch++){
            alphabets[a++] = ch;
        }
        for(int index = shifts.length - 1; index >=0 ; index--){
            suffix+= shifts[index];
            long shift = suffix%26;
            array[index] = alphabets[(s.charAt(index)-'a'+(int)shift)%26];
        }
        String result = "";
        for(int index = 0; index<array.length; index++){
            result+=array[index];
        }
        return result;
    }
}
