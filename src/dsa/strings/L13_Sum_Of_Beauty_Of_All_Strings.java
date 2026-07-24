package dsa.strings;

public class L13_Sum_Of_Beauty_Of_All_Strings {
    public int beautySum(String s) {
        int ans = 0;

        for(int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];

            for(int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = 0;

                for(int f : freq) {
                    if(f > 0) {
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                }

                ans += max - min;
            }
        }

        return ans;
    }
}

//TC : O(n^2)
//SC : O(26)
