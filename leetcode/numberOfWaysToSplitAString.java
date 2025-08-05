class Solution {
    public int numWays(String s) {
        long mod = 1_000_000_007;
        long ones = 0;
        long length = s.length();
        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;
        }
        if (ones == 0)
            return (int)((((length - 1) % mod) * ((length - 2) % mod) / 2) % mod);
        if (ones % 3 != 0)
            return 0;
        long oneThird = ones / 3;
        long twoThird = 2 * oneThird;
        ones = 0;
        long ways1 = 0;
        long ways2 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') ones++;
            if (ones == oneThird) ways1++;
            if (ones == twoThird) ways2++;
        }
        return (int)(((ways1 % mod) * (ways2 % mod)) % mod);
    }
}
