package dsa.dp;

public class L7_Ninja_Training {
    public int maximumPoints(int mat[][]) {
        // code here

        int[] next = new int[4];


        for(int i= mat.length -1; i>=0; i--) {
            int[] curr = new int[4];
            for(int last =2; last>=-1; last--) {
                int ans = 0;

                for(int j=0; j<3;j++) {
                    if(last != j) {
                        ans = Math.max(ans, mat[i][j] + next[j+1]);
                    }
                }

                curr[last+1] = ans;
            }
            next = curr;
        }

        return next[0];
    }
}


//TC : O(n*3*4)
//SC : O(4)


//public int maximumPoints(int mat[][]) {
//    // code here
//
//    int[][] dp = new int[mat.length + 1][4];
//
//
//    for(int i= mat.length -1; i>=0; i--) {
//        for(int last =2; last>=-1; last--) {
//            int ans = 0;
//
//            for(int j=0; j<3;j++) {
//                if(last != j) {
//                    ans = Math.max(ans, mat[i][j] + dp[i+1][j+1]);
//                }
//            }
//
//            dp[i][last+1] = ans;
//        }
//    }
//
//    return dp[0][0];
//}



//TC : O(n*3*4)
//SC : O(n*4)


//public int maximumPoints(int mat[][]) {
//    // code here
//
//    int[][] dp = new int[mat.length][4];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//
//    return rec(0, mat, -1, dp);
//}
//
//int rec(int i, int[][] mat, int last, int[][] dp) {
//    if(i==mat.length) {
//        return 0;
//    }
//
//    if(dp[i][last+1] != -1) {
//        return dp[i][last + 1];
//    }
//
//    int ans = 0;
//
//    for(int j=0; j<3;j++) {
//        if(last != j) {
//            ans = Math.max(ans, mat[i][j] + rec(i+1, mat, j, dp));
//        }
//    }
//
//    return dp[i][last + 1] = ans;
//}

//TC : O(n*3*4)
//SC : O(n*4) + O(n)

//public int maximumPoints(int mat[][]) {
//    // code here
//
//    return rec(0, mat, -1);
//}
//
//int rec(int i, int[][] mat, int last) {
//    if(i==mat.length) {
//        return 0;
//    }
//
//    int ans = 0;
//
//    for(int j=0; j<3;j++) {
//        if(last != j) {
//            ans = Math.max(ans, mat[i][j] + rec(i+1, mat, j));
//        }
//    }
//
//    return ans;
//}

//TC : O(2^n)
//SC : O(n)