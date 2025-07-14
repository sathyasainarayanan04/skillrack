import java.util.regex.*;
class Spreadsheet {
    private int[][] grid;
    private final int R;
    private final int C = 26;
    public Spreadsheet(int rows) {
        this.R = rows;
        this.grid = new int[R][C];
    }
    public int[] getPosition(String cell){
        char col = cell.charAt(0);
        int colIndex = col - 'A';
        int rowIndex = Integer.parseInt(cell.substring(1));
        int[] position = new int[]{rowIndex-1,colIndex};
        return position; 
    }
    public void setCell(String cell, int value) {
        int[] position = getPosition(cell);
        grid[position[0]][position[1]] = value;
    }
    public void resetCell(String cell) {
        int[] position = getPosition(cell);
        grid[position[0]][position[1]]=0;
    }
    public int getValue(String formula) {
        if(!formula.startsWith("="))return 0;
        formula = formula.substring(1);
        Pattern patternObject = Pattern.compile("[A-Z][1-9][0-9]*|\\d+");
        Matcher matcherObject = patternObject.matcher(formula);
        int total = 0;
        while(matcherObject.find()){
            String token = matcherObject.group();
            if(Character.isLetter(token.charAt(0))){
               int[] position = getPosition(token);
               total+=grid[position[0]][position[1]];
            }
            else{
                total+=Integer.valueOf(token);
            }
        }
        return total;
    }
}
