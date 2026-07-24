package dsa.dp;

import java.util.Arrays;

public class L45_Longest_String_Chain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        return getLis(words);
    }

    public int getLis(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<i; j++) {
                if(isValid(i, j, words)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans;
    }

    boolean isValid(int i , int j, String[] words) {
        String word1 = words[j];
        String word2 = words[i];
        int a = 0;
        int b = 0;

        if(word2.length() != 1+word1.length()) {
            return false;
        }

        while(a<word1.length() && b < word2.length()) {
            if(word1.charAt(a) == word2.charAt(b)) {
                a++;
                b++;
            }
            else{
                b++;
            }
        }

        return a==word1.length();
    }
}
