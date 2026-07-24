package dsa.dp;

public class L32_Distinct_SubSequences {
    public int numDistinct(String s, String t) {
        int[] next = new int[t.length() + 1];
        next[t.length()] = 1;
        for(int i=s.length() -1; i>=0; i--) {
            int[] curr = new int[t.length() + 1];
            curr[t.length()] = 1;
            for(int j=t.length() -1; j>=0; j--) {
                if(s.charAt(i) == t.charAt(j)) {
                    curr[j] = next[j]  + next[j+1];
                } else {
                    curr[j] = next[j];
                }
            }
            next = curr;
        }
        return next[0];
    }
}

//TC : O(m*n)
//SC : O(2m)

//public int numDistinct(String s, String t) {
//    int[][] dp = new int[s.length() + 1][t.length() + 1];
//    for(int i= 0; i<dp.length; i++) {
//        dp[i][dp[0].length - 1] = 1;
//    }
//    for(int i=s.length() -1; i>=0; i--) {
//        for(int j=t.length() -1; j>=0; j--) {
//            if(s.charAt(i) == t.charAt(j)) {
//                dp[i][j] = dp[i+1][j]  + dp[i+1][j+1];
//            } else {
//                dp[i][j] = dp[i+1][j];
//            }
//        }
//    }
//    return dp[0][0];
//}

//TC : O(m*n)
//SC : O(m*n)


//public int numDistinct(String s, String t) {
//    int[][] dp = new int[s.length() + 1][t.length() + 1];
//    for(int[] row : dp) {
//        Arrays.fill(row, -1);
//    }
//    return rec(0,0, s, t, dp);
//}
//
//int rec(int i, int j, String s, String t, int[][] dp) {
//    if(j>= t.length()) {
//        return 1;
//    }
//
//    if(i >= s.length()) {
//        return 0;
//    }
//
//    if(dp[i+1][j+1] != -1) {
//        return dp[i+1][j+1];
//    }
//
//    if(s.charAt(i) == t.charAt(j)) {
//        return dp[i+1][j+1] = rec(i+1, j,s,t, dp)  + rec(i+1, j+1, s, t, dp);
//    }
//
//    return dp[i+1][j+1] = rec(i+1, j,s,t, dp);
//}

//TC : O(m*n)
//SC : O(m*n + m+n)



//public int numDistinct(String s, String t) {
//    return rec(0,0, s, t);
//}
//
//int rec(int i, int j, String s, String t) {
//    if(j>= t.length()) {
//        return 1;
//    }
//
//    if(i >= s.length()) {
//        return 0;
//    }
//
//    if(s.charAt(i) == t.charAt(j)) {
//        return rec(i+1, j,s,t)  + rec(i+1, j+1, s, t);
//    }
//
//    return rec(i+1, j,s,t);
//}

//TC : O(2^(m+n))
//SC : O(m+n)