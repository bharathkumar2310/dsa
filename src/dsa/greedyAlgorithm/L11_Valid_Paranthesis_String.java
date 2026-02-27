package dsa.greedyAlgorithm;

class L11_Valid_Paranthesis_String {
    public boolean checkValidString(String s) {

        int min = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                min += 1;
                max+=1;
            }
            else if(s.charAt(i) == ')') {
                min -= 1;
                max-= 1;
            }
            else{
                min-=1;
                max+=1;
            }
            if(min <0) {
                min = 0;
            }
            if(max <0) {
                return false;
            }
        }
        return min==0;
    }
}

//TC : O(n) SC : O(!

// unoptimal approach
//public boolean checkValidString(String s) {
//    Boolean[][] dp = new Boolean[s.length()][s.length()];
//    return rec(0,s, 0, dp);
//}
//
//
//public boolean rec(int i, String s, int range, Boolean[][] dp) {
//
//    if(i == s.length()) {
//        return range == 0;
//    }
//    if(range < 0) {
//        return false;
//    }
//
//    if(dp[i][range] != null) {
//        return dp[i][range];
//    }
//
//    boolean result = false;
//    if(s.charAt(i) == '(') {
//        result = rec(i + 1, s, range + 1, dp);
//    }
//
//    else if(s.charAt(i) == ')') {
//        result =  rec(i + 1,s,range -1, dp);
//    }
//
//    else if(s.charAt(i) == '*') {
//        result = rec(i + 1,s, range -1, dp ) ||rec(i + 1,s, range, dp ) || rec(i + 1,s, range + 1, dp );
//    }
//    dp[i][range] = result;
//    return result;
//}