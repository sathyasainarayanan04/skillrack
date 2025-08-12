class Solution {
    private static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
       List<Integer> powers = new ArrayList<>();
       for(int index=0;index<32;index++){
         if((n & (1<<index)) != 0 ){
            powers.add(1<<index);
         }
       }
       System.out.println(powers);
       int result[] =new int[queries.length];
       for(int index = 0;index<queries.length;index++){
        int[] query = queries[index];
        int start = query[0];
        int end = query[1];
        long product = 1;
        for(int iterator = start;iterator<=end;iterator++){
           product = (product*powers.get(iterator))%MOD;
        }
        result[index] = (int)product;
       }
       return result;
    }
}
