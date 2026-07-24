package dsa.strings;

import java.util.HashMap;

public class L11_String_To_Int_Atoi {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        if(s.length() == 0) {
            return 0;
        }
        if(s.charAt(0) == '-') {
            sign = -1;
        }
        long ans = 0;
        for(int i = 0; i<s.length() ; i++) {

            if(s.charAt(i)- '0' >= 0 && s.charAt(i) - '0' <= 9 ) {
                ans = (ans * 10) + s.charAt(i) - '0';
                if(ans * sign >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if(ans * sign <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }

            else {
                if(i==0 && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                    continue;

                }
                else {
                    break;
                }
            }
        }
        return (int)(sign * ans);
    }
}

//TC : O(n)
//SC : O(1)