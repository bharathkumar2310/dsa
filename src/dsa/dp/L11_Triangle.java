package dsa.dp;

import java.util.List;

public class L11_Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] next = new int[triangle.size()];
        for(int j=0; j<triangle.size(); j++) {
            next[j] = triangle.get(triangle.size() -1).get(j);
        }

        for(int i= triangle.size() -2; i>=0;i--) {
            int[] curr = new int[triangle.size()];
            for(int j=i; j>=0; j--) {
                int diag = triangle.get(i).get(j) + next[j+1];
                int down = triangle.get(i).get(j) + next[j];

                curr[j] = Math.min(diag, down);
            }

            next = curr;
        }
        return next[0];
    }
}


//TC : O(n(n+1)/2): O(N^2)
//SC : O(n)

//public int minimumTotal(List<List<Integer>> triangle) {
//    int[][] dp = new int[triangle.size()][triangle.size()];
//    for(int j=0; j<triangle.size(); j++) {
//        dp[triangle.size() -1][j] = triangle.get(triangle.size() -1).get(j);
//    }
//
//    for(int i= triangle.size() -2; i>=0;i--) {
//        for(int j=i; j>=0; j--) {
//            int diag = triangle.get(i).get(j) + dp[i+1][j+1];
//            int down = triangle.get(i).get(j) + dp[i+1][j];
//
//            dp[i][j] = Math.min(diag, down);
//
//
//        }
//    }
//    return dp[0][0];
//}



//TC : O(n(n+1)/2): O(N^2)
//SC : O(n^2 )

//public int minimumTotal(List<List<Integer>> triangle) {
//    int[][] dp = new int[triangle.size()][triangle.size()];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -(int)1e9);
//    }
//    return rec(0, 0 ,triangle, dp);
//}
//
//int rec(int i, int j,  List<List<Integer>> triangle, int[][] dp) {
//    if(i== triangle.size() - 1) {
//        return triangle.get(i).get(j);
//    }
//
//    if(dp[i][j] != -(int)1e9) {
//        return dp[i][j];
//    }
//
//    int diag = triangle.get(i).get(j) + rec(i+1, j+1, triangle, dp);
//    int down = triangle.get(i).get(j) + rec(i+1, j, triangle, dp);
//
//    return dp[i][j] = Math.min(diag, down);
//}

//TC : O(n(n+1)/2): O(N^2)
//SC : O(n^2 +n)

//public int minimumTotal(List<List<Integer>> triangle) {
//    return rec(0, 0 ,triangle);
//}
//
//int rec(int i, int j,  List<List<Integer>> triangle) {
//    if(i== triangle.size() - 1) {
//        return triangle.get(i).get(j);
//    }
//
//    int diag = triangle.get(i).get(j) + rec(i+1, j+1, triangle);
//    int down = triangle.get(i).get(j) + rec(i+1, j, triangle);
//
//    return Math.min(diag, down);
//}

//TC : O(2^n)
//SC : O(n)