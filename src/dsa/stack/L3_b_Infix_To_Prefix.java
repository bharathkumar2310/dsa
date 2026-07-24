package dsa.stack;

import java.util.Stack;

public class L3_b_Infix_To_Prefix {
    public String infixToPrefix(String s) {
        // code here

        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i=s.length() -1; i>=0; i--) {
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')  ) {
                ans.append(s.charAt(i));
            }
            else if (s.charAt(i) == ')')  {
                st.push(s.charAt(i));
            }
            else if(s.charAt(i) == '(') {
                while(st.peek() != ')') {
                    ans.append(st.pop());
                }
                st.pop();
            }
            else if(s.charAt(i) == '^') {
                while(!st.isEmpty() && st.peek() == '^') {
                    ans.append(st.pop());
                }
                st.push(s.charAt(i));
            }
            else {
                while(!st.isEmpty() && priority(s.charAt(i)) <  priority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(s.charAt(i));
            }
        }

        while(!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }

    public static int priority(char c) {
        if(c == '*' || c == '/') {
            return 1;
        }
        if(c == '+' || c == '-') {
            return 0;
        }
        if(c == '^') {
            return 2;
        }
        return -1;
    }
}

//TC : O(n)
//SC : O(n)