package dsa.stack;

import java.util.Stack;

public class L14_Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            while(!st.isEmpty() && st.peek() > num.charAt(i) - '0' && k>0) {
                st.pop();
                k--;
            }
            st.add(num.charAt(i) - '0');
        }

        StringBuilder ans = new StringBuilder();
        int l= 0;
        while(!st.isEmpty() && k>0) {
            st.pop();
            k--;
        }
        if(st.isEmpty()) {
            return "0";
        }
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans =  ans.reverse();

        int ind = 0;
        while(ind < ans.length() && ans.charAt(ind) == '0') {
            ind++;
        }

        return ind == ans.length()
                ? "0"
                : ans.substring(ind);

    }
}

//TC : O(4n)
//SC : O(n +n) = O(2n)