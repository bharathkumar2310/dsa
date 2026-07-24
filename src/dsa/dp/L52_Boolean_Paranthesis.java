package dsa.dp;

public class L52_Boolean_Paranthesis {

    static int countWays(String s) {
        // code here
        int[][][] dp = new int[s.length()][s.length()][2];

        for(int i=0; i<s.length(); i++) {
            for(int j=0; j<s.length(); j++) {
                for(int k=0; k<2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return rec(0, s.length() - 1, s, 1, dp);
    }

    static int rec(int i, int j, String s, int k, int[][][] dp) {

        if(i==j) {
            if(k == 1) {
                if(s.charAt(i) == 'T') {
                    return 1;
                } else {
                    return 0;
                }
            }
            if(k==0) {
                if(s.charAt(i) == 'F') {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        if(dp[i][j][k] !=-1) {
            return dp[i][j][k];
        }

        int ways = 0;


        for(int ind = i+1; ind<j; ind=ind+2) {
            int lF = rec(i,ind-1,s, 0, dp);
            int rF = rec(ind+1,j,s, 0, dp);
            int lT = rec(i, ind-1, s, 1, dp);
            int rT = rec(ind + 1, j, s, 1, dp);

            if(s.charAt(ind) == '&') {
                if(k==1) {
                    ways += lT * rT;
                }
                else {
                    ways += lF*rT + rF*lT + rF*lF;
                }
            }
            else if(s.charAt(ind) == '|') {
                if(k==1) {
                    ways += lF*rT + rF*lT + rT*lT;
                } else {
                    ways += lF * rF;
                }

            }
            else {
                if(k==1) {
                    ways += lF * rT + rF * lT;
                } else {
                    ways += rT * lT + rF * lF;
                }

            }
        }

        return dp[i][j][k] = ways;
    }

}

//TC : O(n^3)
//SC : O(n^2)

//static int countWays(String s) {
//    // code here
//    return rec(0, s.length() - 1, s, true);
//}

//static int rec(int i, int j, String s, boolean isTrue) {
//
//    if(i==j) {
//        if(isTrue) {
//            if(s.charAt(i) == 'T') {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//        if(!isTrue) {
//            if(s.charAt(i) == 'F') {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//    }
//
//    int ways = 0;
//
//    for(int ind = i+1; ind<j; ind=ind+2) {
//        int lF = rec(i,ind-1,s, false);
//        int rF = rec(ind+1,j,s, false);
//        int lT = rec(i, ind-1, s, true);
//        int rT = rec(ind + 1, j, s, true);
//
//        if(s.charAt(ind) == '&') {
//            if(isTrue) {
//                ways += lT * rT;
//            }
//            else {
//                ways += lF*rT + rF*lT + rF*lF;
//            }
//        }
//        else if(s.charAt(ind) == '|') {
//            if(isTrue) {
//                ways += lF*rT + rF*lT + rT*lT;
//            } else {
//                ways += lF * rF;
//            }
//
//        }
//        else {
//            if(isTrue) {
//                ways += lF * rT + rF * lT;
//            } else {
//                ways += rT * lT + rF * lF;
//            }
//
//        }
//    }
//
//    return ways;
//}