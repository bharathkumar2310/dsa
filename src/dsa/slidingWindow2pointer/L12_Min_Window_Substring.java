package dsa.slidingWindow2pointer;

import java.util.HashMap;
import java.util.Map;

class L12_Min_Window_Substring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapFreq = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            mapFreq.put(t.charAt(i), mapFreq.getOrDefault(t.charAt(i), 0) + 1);
        }
        int ans = (int)1e9;
        int right = 0;
        int left = 0;
        int startIndex =-1;
        int endIndex = -1;
        int count  = 0;
        while(right < s.length()) {

            if(mapFreq.get(s.charAt(right)) != null && mapFreq.get(s.charAt(right)) >= 1) {
                count++;
            }

            mapFreq.put(s.charAt(right), mapFreq.getOrDefault(s.charAt(right), 0) - 1);

            while(count == t.length()) {
                int ans1 = right - left + 1;
                if(ans1< ans) {
                    startIndex = left;
                    endIndex = right;
                    ans = ans1;

                }
                mapFreq.put(s.charAt(left), mapFreq.getOrDefault(s.charAt(left), 0) + 1);
                if(mapFreq.get(s.charAt(left)) >= 1) {
                    count--;
                }
                left++;

            }

            right++;
        }

        if(startIndex == -1) {
            return "";
        }
        return s.substring(startIndex, endIndex + 1);
    }
}


//TC : o(2n + m)
//SC : O(256) --> if all alp, digit , everything
