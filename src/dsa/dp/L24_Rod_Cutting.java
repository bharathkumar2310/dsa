package dsa.dp;

public class L24_Rod_Cutting {
    public int cutRod(int[] price) {
        // code here
        int[] next = new int[price.length + 1];
        for(int i = price.length -1; i>=0; i--) {
            int[] curr = new int[price.length + 1];
            for(int j=0; j<=price.length; j++) {
                int take = 0;
                if(j-i - 1 >= 0) {
                    take = price[i] + curr[j- i -1];
                }
                int notTake = next[j];

                curr[j] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[price.length];
    }
}


//O(n^2)
//O(n)

//public int cutRod(int[] price) {
//    // code here
//    int[][] dp = new int[price.length + 1][price.length + 1];
//    for(int i = price.length -1; i>=0; i--) {
//        for(int j=0; j<=price.length; j++) {
//            int take = 0;
//            if(j-i - 1 >= 0) {
//                take = price[i] + dp[i][j- i -1];
//            }
//            int notTake = dp[i+1][j];
//
//            dp[i][j] = Math.max(take, notTake);
//        }
//    }
//    return dp[0][price.length];
//}


//O(n^2)
//O(n^2)


//public int cutRod(int[] price) {
//    // code here
//    int[][] dp = new int[price.length + 1][price.length + 1];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(0, price, price.length, dp);
//}
//
//int rec(int i, int[] price, int n, int[][] dp) {
//
//    if(i==price.length) {
//        return 0;
//    }
//
//    if(dp[i][n] != -1) {
//        return dp[i][n];
//    }
//
//    int take = 0;
//    if(n-i - 1 >= 0) {
//        take = price[i] + rec(i, price, n- i - 1, dp);
//    }
//    int notTake = rec(i + 1, price, n, dp);
//
//    return dp[i][n] = Math.max(take, notTake);
//}


//O(n^2)
//O(2n^2)

//public int cutRod(int[] price) {
//    // code here
//    return rec(0, price, price.length);
//}
//
//int rec(int i, int[] price, int n) {
//
//    if(i==price.length) {
//        return 0;
//    }
//
//    int take = 0;
//    if(n-i - 1 >= 0) {
//        take = price[i] + rec(i, price, n- i - 1);
//    }
//    int notTake = rec(i + 1, price, n);
//
//    return Math.max(take, notTake);
//}

//TC : O(2^(price.length+ n))
//SC : O(price.length + n)