package dsa.slidingWindow2pointer;

class L6_Longest_Substring_With_AtMost_K_Distinct_Char {
    public int longestKSubstr(String s, int k) {
        // code here
        int[] alp = new int[26];

        int left = 0;
        int right = 0;
        int count = 0;
        int ans = 0;
        while(right < s.length()) {
            if(alp[s.charAt(right) - 'a'] == 0) {
                count++;
            }
            alp[s.charAt(right) - 'a']++;
            if(count > k) {
                alp[s.charAt(left) - 'a']--;
                if(alp[s.charAt(left) - 'a'] == 0) {
                    count--;
                }
                left++;
            }
            if(count <= k) {
                ans = Math.max(ans, right - left + 1);

            }
            right++;

        }
        return ans;
    }
}

//TC : O(n)
//SC : O(1)