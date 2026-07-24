package dsa.strings;

public class L14_Min_reversals_To_Make_String_Balanced {
    public int countMinReversals(String s) {
        // code here
        if(s.length() % 2 == 1) {
            return -1;
        }
        int cnt = 0;
        int open= 0;
        int close = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '{') {
                open++;
            }
            else {
                if(open>0) {
                    open--;
                }
                else {
                    close++;
                }
            }
        }

        if((open + close) % 2 != 0) {
            return -1;
        }

        return (open + 1)/2 + (close + 1)/2;
    }
}

//TC : O(n)
//SC : O(1)