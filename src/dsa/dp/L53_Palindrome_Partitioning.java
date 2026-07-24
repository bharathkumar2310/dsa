package dsa.dp;

public class L53_Palindrome_Partitioning {

    static int palPartition(String s) {
        // code here
        int[] dp = new int[s.length()];
        for(int i=s.length() -1; i>=0; i--) {
            if(isPalindrome(i,s.length() - 1, s)) {
                dp[i]= 0;
                continue;
            }

            int ans1 = (int)1e9;
            for(int ind = i; ind < s.length() - 1 ; ind ++) {

                if(isPalindrome(i, ind, s)) {
                    int ans = 1 + dp[ind + 1];
                    ans1 =  Math.min(ans, ans1);
                }

            }
            dp[i] = ans1;
        }
        return dp[0];
    }


    static boolean isPalindrome(int i, int j , String s) {

        while(i<= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}

//TC : O(n^3)
//SC : O(n^2)


//static int palPartition(String s) {
//    // code here
//    int[] dp = new int[s.length()];
//    Arrays.fill(dp, -1);
//    return rec(0, s, dp);
//}
//
//static int rec(int i , String s, int[] dp) {
//
//    if(i>=s.length()) {
//        return 0;
//    }
//
//    if(isPalindrome(i,s.length() - 1, s)) {
//        return 0;
//    }
//
//    if(dp[i] != -1) {
//        return dp[i];
//    }
//
//
//    int ans1 = (int)1e9;
//    for(int ind = i; ind < s.length() - 1 ; ind ++) {
//
//        if(isPalindrome(i, ind, s)) {
//            int ans = 1 + rec(ind + 1, s, dp);
//            ans1 =  Math.min(ans, ans1);
//        }
//
//    }
//
//    return dp[i] = ans1;
//}
//
//static boolean isPalindrome(int i, int j , String s) {
//
//    while(i<= j) {
//        if(s.charAt(i) != s.charAt(j)) {
//            return false;
//        }
//        i++;
//        j--;
//    }
//
//    return true;
//}

//TC : O(n^3)
//SC : O(n^2) + O(n)

//static int palPartition(String s) {
//    // code here
//    return rec(0, s);
//}
//
//static int rec(int i , String s) {
//
//    if(i>=s.length()) {
//        return 0;
//    }
//
//    if(isPalindrome(i,s.length() - 1, s)) {
//        return 0;
//    }
//
//    int ans1 = (int)1e9;
//    for(int ind = i; ind < s.length() - 1 ; ind ++) {
//
//        if(isPalindrome(i, ind, s)) {
//            int ans = 1 + rec(ind + 1, s);
//            ans1 =  Math.min(ans, ans1);
//        }
//
//    }
//
//    return ans1;
//}
//
//static boolean isPalindrome(int i, int j , String s) {
//
//    while(i<= j) {
//        if(s.charAt(i) != s.charAt(j)) {
//            return false;
//        }
//        i++;
//        j--;
//    }
//
//    return true;
//}


//TC : O(2^n)
//SC : O(n)