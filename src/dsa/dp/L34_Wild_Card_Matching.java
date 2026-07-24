package dsa.dp;

import java.util.Arrays;

public class L34_Wild_Card_Matching {
    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return rec(s.length() - 1, p.length() - 1, s, p, dp);
    }

    boolean rec(int i, int j, String s, String p, int[][] dp) {

        if (i < 0 && j < 0) {
            return true;
        }

        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (j < 0) {
            return false;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        boolean ans;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = rec(i - 1, j - 1, s, p, dp);
        }
        else if (p.charAt(j) == '*') {
            ans = rec(i - 1, j, s, p, dp) ||
                    rec(i, j - 1, s, p, dp);
        }
        else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}

//TC : O(m * n)
//SC : O(m*n + m+n)


//public boolean isMatch(String s, String p) {
//    return rec(s.length() -1, p.length() -1, s, p);
//}

//boolean rec(int i, int j, String s, String p) {
//    if(i<0 ) {
//        for(int k=0; k<=j; k++) {
//            if(p.charAt(k) != '*') {
//                return false;
//            }
//        }
//        return true;
//    }
//    if( j<0) {
//        return false;
//    }
//
//    if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
//        return rec(i-1, j-1, s, p);
//    }
//    else if(p.charAt(j) == '*') {
//        return rec(i-1, j, s, p) || rec(i, j-1, s, p);
//    }
//
//    return false;
//}

//TC : O(2^(m+n))
//SC : O(m+n)