class Solution {
    public int minFlips(String s) {
        int length = s.length();
        StringBuilder alternateString1 = new StringBuilder();
        StringBuilder alternateString2 = new StringBuilder();
        for(int index=0; index < 2*length; index++){
            alternateString1.append(index%2 == 0 ? '0' : '1');
            alternateString2.append(index%2 == 0 ? '1' : '0');
        }
        String newString = s + s;
        int flipsToBeMade = length;
        int difference1 =0, difference2 = 0;
        int left =0;
        for(int right =0; right < 2*length; right++){
            if(newString.charAt(right) != alternateString1.charAt(right))difference1++;
            if(newString.charAt(right) != alternateString2.charAt(right))difference2++;
            if(right - left + 1 > length){
                if(newString.charAt(left)!=alternateString1.charAt(left))difference1--;
                if(newString.charAt(left)!=alternateString2.charAt(left))difference2--;
                left++;
            }
            if(right - left + 1 == length){
                flipsToBeMade = Math.min(flipsToBeMade, Math.min(difference1, difference2));
            }
        }
        return flipsToBeMade;
    }
}
