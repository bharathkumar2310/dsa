package dsa.dp;

public class L25_Longest_Common_SubSequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];

        for(int i=0; i<n; i++) {
            int[] curr = new int[m+1];
            for(int j=0; j<m; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {

                    curr[j+1] = 1+ prev[j];

                }
                else{
                    curr[j+1] = Math.max(curr[j], prev[j+1]);
                }
            }

            prev = curr;
        }

        return prev[m];
    }
}

//TC : O(n*m)
//SC : O(2m)

//public int longestCommonSubsequence(String text1, String text2) {
//
//    int n = text1.length();
//    int m = text2.length();
//
//    int[][] dp = new int[n+1][m+1];
//
//    for(int i=0; i<n; i++) {
//        for(int j=0; j<m; j++) {
//            if(text1.charAt(i) == text2.charAt(j)) {
//
//                dp[i+1][j+1] = 1 + dp[i][j];
//
//            }
//            else{
//                dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
//            }
//        }
//    }
//
//    return dp[n][m];
//}

//TC : O(n *m)
//SC : O(n*m)

//public int longestCommonSubsequence(String text1, String text2) {
//    int[][] dp = new int[text1.length()][text2.length()];
//    for(int[] row : dp) {
//        Arrays.fill(row, -1);
//    }
//    return rec(0,0, text1, text2, dp);
//}
//
//
//int rec(int i, int j , String text1, String text2, int[][] dp) {
//    if(i >= text1.length() || j >= text2.length()) {
//        return 0;
//    }
//
//    if(dp[i][j] != -1) {
//        return dp[i][j];
//    }
//
//    if(text1.charAt(i) == text2.charAt(j)) {
//        return dp[i][j] = 1 + rec(i+1, j+1, text1, text2, dp);
//    }
//
//    return dp[i][j] = Math.max(rec(i+1, j, text1, text2, dp) , rec(i, j+1, text1, text2, dp) );
//}

//TC : O(n *m)
//SC : O(n*m + n+m)


//public int longestCommonSubsequence(String text1, String text2) {
//    return rec(0,0, text1, text2);
//}
//
//
//int rec(int i, int j , String text1, String text2) {
//    if(i >= text1.length() || j >= text2.length()) {
//        return 0;
//    }
//
//    if(text1.charAt(i) == text2.charAt(j)) {
//        return 1 + rec(i+1, j+1, text1, text2);
//    }
//
//    return Math.max(rec(i+1, j, text1, text2) , rec(i, j+1, text1, text2) );
//}

//TC : O(2^(n+m))
//SC : O(n+m)