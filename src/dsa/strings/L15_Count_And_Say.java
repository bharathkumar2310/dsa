package dsa.strings;

public class L15_Count_And_Say {
    public String countAndSay(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "1";
        for(int i=2; i<n+1; i++) {
            dp[i] = str(dp[i-1]);
        }

        return dp[n];
    }

    String str(String ans) {
        StringBuilder build = new StringBuilder();
        int no = 0;
        int cnt = 0;
        int i = 0;
        while(i<ans.length()) {

            if(ans.charAt(i) - '0' == no) {
                cnt++;
            }
            else {
                if(i!=0) {
                    build.append(String.valueOf(cnt));
                    build.append(String.valueOf(no));
                }
                no = ans.charAt(i) - '0';
                cnt = 1;
            }
            i++;
        }
        build.append(String.valueOf(cnt));
        build.append(String.valueOf(no));

        return build.toString();
    }
}

//TC : O(n*m)
//SC : O(n)



//public String countAndSay(int n) {
//    int[] dp = new int[n]
//    return rec(n);
//}
//
//String rec(int n) {
//    if(n == 1) {
//        return "1";
//    }
//
//    String ans = rec(n-1);
//    return str(ans);
//}
//
//String str(String ans) {
//    StringBuilder build = new StringBuilder();
//    int no = 0;
//    int cnt = 0;
//    int i = 0;
//    while(i<ans.length()) {
//
//        if(ans.charAt(i) - '0' == no) {
//            cnt++;
//        }
//        else {
//            if(i!=0) {
//                build.append(String.valueOf(cnt));
//                build.append(String.valueOf(no));
//            }
//            no = ans.charAt(i) - '0';
//            cnt = 1;
//        }
//        i++;
//    }
//    build.append(String.valueOf(cnt));
//    build.append(String.valueOf(no));
//
//    return build.toString();
//}