package dsa.dp;

// same as L25_Longest_Common_SubSequence

public class L31_Shortest_Common_Super_Sequence {
    public String shortestCommonSupersequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {

                    dp[i+1][j+1] = 1 + dp[i][j];

                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        int a = n;
        int b = m;
        StringBuilder ans = new StringBuilder();

        while(a>0 && b>0) {

            if(text1.charAt(a-1) == text2.charAt(b-1)) {
                ans.append(text1.charAt(a-1));
                a--;
                b--;
            } else {
                if(dp[a-1][b] > dp[a][b-1]) {
                    ans.append(text1.charAt(a-1));
                    a--;
                } else {
                    ans.append(text2.charAt(b-1));
                    b--;

                }
            }

        }
        while(a > 0) {
            ans.append(text1.charAt(a - 1));
            a--;
        }

        while(b > 0) {
            ans.append(text2.charAt(b - 1));
            b--;
        }
        return ans.reverse().toString();
    }
}

//TC : O(n*m)
//SC : O(n*m)