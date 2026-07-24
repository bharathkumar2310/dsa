package dsa.LeetCode.Partition_On_DP;

import java.util.Arrays;

public class LeetCode_1039_Min_Score_Triangulation_Of_Polygon {
    public int minScoreTriangulation(int[] values) {

        int[][] dp = new int[values.length][values.length];
        for(int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return rec(0, values.length - 1, values, dp);
    }

    int rec(int i, int j, int[] values, int[][] dp)  {

        if(j - i< 2) {
            return 0 ;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = (int) 1e9;



        for(int ind = i+1; ind<j; ind++ ) {
            int ans1 = (values[i] * values[ind] * values[j]) + rec(i, ind, values, dp) + rec(ind , j, values, dp);
            ans = Math.min(ans, ans1);
        }
        return dp[i][j] = ans;
    }
}

//TC : O(n^2)
//SC : O(n^2 + n)