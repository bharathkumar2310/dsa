package dsa.strings;

public class L9_Max_Depth_Of_Paranthesis {
    public static int maxDepth(String s) {
        // code here
        int ans = 0;
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')  {
                cnt++;
                ans = Math.max(ans, cnt);
            }
            else if(s.charAt(i) == ')') {
                cnt--;

            }

        }
        return ans;
    }
}

//TC : O(n)
//SC: O(1)