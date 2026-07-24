package dsa.strings;

public class L17_Longest_Happy_Prefix {
    public String longestPrefix(String s) {
        int[] prefix = new int[s.length()];
        int len = 0;
        int i = 1;
        while(i<s.length()) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            }
            else {

                if(len != 0) {
                    len = prefix[len - 1];
                }
                else {
                    prefix[i] = 0;
                    i++;
                }
            }


        }

        return s.substring(0, prefix[s.length() - 1]);
    }
}

//TC : O(n)
//SC : O(n)