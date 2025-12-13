package DP.SequenceDP.RegxDP.lc44;

public class Solution2 {
    // rorate array
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // m >=0, n >0
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = true;
            } else {
                break;
            }
        }

        // m > 0, n > 0
        // boolean leftUp = dp[0];
        for (int i = 1; i <= m; i++) {
            // dp[i][0] is false
            boolean leftUp = i == 1 ? true : false;
            for (int j = 1; j <= n; j++) {
                boolean tmp = dp[j];
                if (p.charAt(j - 1) == '*') {
                    if (i > 1) {
                        dp[j] = dp[j] || dp[j-1]; // [i-1][j]
                    }
                    // else j == 1, can not change, since dp[0][j] is always false
                }
                else {
                    dp[j] = leftUp && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                }

                leftUp = tmp;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.isMatch("abceb", "*a*b");
    }
}
