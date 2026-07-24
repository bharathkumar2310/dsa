package dsa.strings;

public class L1_Remove_Outermost_Paranthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')  {
                cnt++;
                if(cnt != 1) {
                    ans.append(s.charAt(i));
                }
            }
            else {
                cnt--;
                if(cnt != 0) {
                    ans.append(s.charAt(i));
                }
            }

        }
        return ans.toString();
    }
}

//TC : O(n)
//SC : O(n)