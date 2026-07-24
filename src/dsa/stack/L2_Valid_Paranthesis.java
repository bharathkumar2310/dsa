package dsa.stack;

import java.util.Stack;

public class L2_Valid_Paranthesis {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch  = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            if(ch == ')' || ch == '}' || ch == ']') {
                if(st.isEmpty()) return false;

                char top = st.pop();

                if((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '['))
                    return false;
            }
        }

        return st.isEmpty();
    }
}

//TC : O(n)
//SC : O(n)