package dsa.dp;

public class L27_Longest_Common_SubString {
    public int longCommSubstr(String s1, String s2) {
        // code here
        int[] prev = new int[s2.length() + 1];
        int max =0;

        for(int i=0; i<s1.length(); i++) {
            int[] curr = new int[s2.length() + 1];
            for(int j=0; j<s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    curr[j + 1] = 1 + prev[j];
                    max = Math.max(max, curr[j+1]);
                }
            }
            prev = curr;
        }
        return max;
    }
}
//TC : O(n*m)
//SC : O(2m)

//public int longCommSubstr(String s1, String s2) {
//    // code here
//    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
//    int max =0;
//
//    for(int i=0; i<s1.length(); i++) {
//        for(int j=0; j<s2.length(); j++) {
//            if(s1.charAt(i) == s2.charAt(j)) {
//                dp[i+ 1][j + 1] = 1 + dp[i][j];
//                max = Math.max(max, dp[i+1][j+1]);
//            }
//        }
//    }
//    return max;
//}

//TC :O(n*m)
//SC : O(n*m)

//public int longCommSubstr(String s1, String s2) {
//    // code here
//
//    return rec(0,0,s1, s2, 0);
//
//}
//
//int rec(int i, int j, String s1, String s2, int count) {
//    if(i == s1.length() || j == s2.length())
//        return count;
//
//    int currCount = count;
//
//    if(s1.charAt(i) == s2.charAt(j)) {
//        currCount = rec(i + 1, j + 1, s1, s2, count + 1);
//    }
//
//    int skipS1 = rec(i + 1, j,s1, s2, 0);
//    int skipS2 = rec(i, j + 1,s1, s2, 0);
//
//    return Math.max(currCount, Math.max(skipS1, skipS2));
//}