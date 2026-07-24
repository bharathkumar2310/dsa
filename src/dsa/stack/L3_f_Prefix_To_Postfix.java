package dsa.stack;

import java.util.Stack;

public class L3_f_Prefix_To_Postfix {
    static String preToPost(String s) {
        // code here
        Stack<String> st = new Stack<>();
        for(int i=s.length()-1; i>=0; i--) {
            if((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')  ) {
                st.push(String.valueOf(s.charAt(i)));
            }
            else {
                String ele1 = st.pop();
                String ele2 = st.pop();
                StringBuilder ele3 = new StringBuilder();
                ele3.append(ele1);
                ele3.append(ele2);
                ele3.append(s.charAt(i));

                st.push(ele3.toString());
            }
        }
        return st.pop();
    }
}
