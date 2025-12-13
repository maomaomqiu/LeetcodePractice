package DP.SequenceDP.RegxDP.lc10;

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int j = 1; j <= n; j++)
        {
            if (p.charAt(j - 1) == '*') f[0][j] = f[0][j-2];
            else {
                f[0][j] = false;
            }
        }

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                // p[j] is not '*'
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                        f[i][j] = f[i-1][j-1];
                    }
                }
                else {
                    // p[j] is '*' P[j] map to j-1
                    // p[j-1] won't be '*'

                    // '*' make p[j-1] appear 0
                    f[i][j] = f[i][j - 2];

                    // '*' make p[j-1] appear >= 1
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == s.charAt(i - 1)) {
                        f[i][j] |= f[i - 1][j];
                    }
                }
            }
        }

        return f[m][n];
    }
}