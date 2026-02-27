package dsa.slidingWindow2pointer;

class L8_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int[] alp = new int[26];
        int ans = 0;
        int maxCount = 0;
        int right = 0;
        int left = 0;

        while(right< s.length()) {

            alp[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, alp[s.charAt(right) - 'A']);
            int total = right - left + 1;
            if(total - maxCount > k) {
                alp[s.charAt(left) - 'A']--;
                maxCount = 0;
                for(int i=0; i<26; i++) {
                    maxCount = Math.max(maxCount, alp[i]);
                }
                left++;
                total =right - left + 1;
            }
            if(total - maxCount <= k) {
                ans = Math.max(ans, right - left + 1);

            }

            right++;
        }

        return ans;
    }
}


//TC : O(n)
//SC : O(1)