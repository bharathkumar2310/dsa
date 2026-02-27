package dsa.slidingWindow2pointer;

import java.util.Arrays;

class L3_Longest_SubString_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int[] alp = new int[256];
        Arrays.fill(alp, -1);
        int left = 0;
        int right = 0;
        int ans = 0;

        while(right < s.length()) {
            if(alp[s.charAt(right)] >= left) {
                left = alp[s.charAt(right)] + 1;
            }
            alp[s.charAt(right)] = right;
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}

//TC : O(n)
//SC : O(256)
