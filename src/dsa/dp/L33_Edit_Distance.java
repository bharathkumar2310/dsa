package dsa.dp;

public class L33_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int[] prev = new int[word2.length() + 1];

        for(int i=0; i<prev.length; i++) {
            prev[i] = i;
        }
        prev[0] = 0;

        for(int i=0; i<word1.length(); i++) {
            int[] curr = new int[word2.length() + 1];
            curr[0] = i + 1;
            for(int j=0; j< word2.length();j++) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    curr[j+1] = prev[j];
                }
                else  {

                    int insert = 1 + curr[j];
                    int replace = 1 + prev[j];
                    int delete = 1 + prev[j+1];
                    curr[j+1] = Math.min(insert, Math.min(delete, replace));

                }
            }
            prev = curr;
        }

        return prev[word2.length()];
    }
}

//TC : O(m*n)
//SC : O(2m)

//public int minDistance(String word1, String word2) {
//    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//    for(int i=0; i<dp.length; i++) {
//        dp[i][0] = i;
//    }
//    for(int i=0; i<dp[0].length; i++) {
//        dp[0][i] = i;
//    }
//    dp[0][0] = 0;
//
//    for(int i=0; i<word1.length(); i++) {
//        for(int j=0; j< word2.length();j++) {
//            if(word1.charAt(i) == word2.charAt(j)) {
//                dp[i+1][j+1] = dp[i][j];
//            }
//            else  {
//
//                int insert = 1 + dp[i+1][j];
//                int replace = 1 + dp[i][j];
//                int delete = 1 + dp[i][j+1];
//                dp[i+1][j+1] = Math.min(insert, Math.min(delete, replace));
//
//            }
//        }
//    }
//
//    return dp[word1.length()][word2.length()];
//}

//TC : O(m*n)
//SC : O(m*n)


//public int minDistance(String word1, String word2) {
//    int[][] dp = new int[word1.length()][word2.length()];
//    for(int[] rows : dp) {
//        Arrays.fill(rows, -1);
//    }
//    return rec(word1.length() -1 , word2.length() -1, word1, word2, dp);
//}
//
//int rec(int i, int j, String word1, String word2, int[][] dp) {
//
//    if(i<0 && j<0) {
//        return 0;
//    }
//    if(i<0) {
//        return j + 1;
//    }
//    if(j<0) {
//        return i + 1;
//    }
//
//    if(dp[i][j] != -1) {
//        return dp[i][j];
//    }
//
//
//    if(word1.charAt(i) == word2.charAt(j)) {
//        return dp[i][j] = rec(i-1, j-1, word1, word2, dp);
//    }
//
//    int insert = 1 + rec(i, j - 1, word1, word2, dp);
//    int replace = 1 + rec(i-1, j-1, word1, word2, dp);
//    int delete = 1 + rec(i-1, j, word1, word2, dp);
//
//    return dp[i][j] = Math.min(insert, Math.min(delete, replace));
//
//}

//TC : O(m*n)
//SC : O(m*n + m +n)

//public int minDistance(String word1, String word2) {
//    return rec(word1.length() -1 , word2.length() -1, word1, word2);
//}
//
//int rec(int i, int j, String word1, String word2) {
//
//    if(i<0 && j<0) {
//        return 0;
//    }
//    if(i<0) {
//        return j + 1;
//    }
//    if(j<0) {
//        return i + 1;
//    }
//
//
//    if(word1.charAt(i) == word2.charAt(j)) {
//        return rec(i-1, j-1, word1, word2);
//    }
//
//    int insert = 1 + rec(i, j - 1, word1, word2);
//    int replace = 1 + rec(i-1, j-1, word1, word2);
//    int delete = 1 + rec(i-1, j, word1, word2);
//
//    return Math.min(insert, Math.min(delete, replace));
//
//}

// TC : O(3^(m+n))
// SC : O(n)