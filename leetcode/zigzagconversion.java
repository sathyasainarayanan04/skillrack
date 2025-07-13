class Solution {
    public String convert(String s, int numRows) {
        String[] row = new String[numRows];
        int counter = 0;
        int direction=1;
        boolean isGoingDown = false;
        String str="";
        if(numRows==1 || s.length()<=numRows)return s;
        for(int index=0;index<numRows;index++){
            row[index] = "";
        }
        for(int index=0;index<s.length();index++){
            
            if(counter==0 || counter==numRows-1)isGoingDown = !isGoingDown;
            if(isGoingDown){
                row[counter]+=s.charAt(index);
                counter++;
            }
            else{
                row[counter]+=s.charAt(index);
                counter--;
            }
        }
        for(int index=0;index<numRows;index++){
            str+=row[index];
        }
        return str;
    }
}
