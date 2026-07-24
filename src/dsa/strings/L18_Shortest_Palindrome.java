package dsa.strings;

public class L18_Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String s1  = s + '#' + sb.toString();

        int[] prefix = new int[s1.length()];

        int i= 1;
        int len = 0;

        while(i<s1.length()) {
            if(s1.charAt(i) == s1.charAt(len)) {
                len++;
                prefix[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = prefix[len-1];
                }
                else {
                    prefix[i] = 0;
                    i++;
                }
            }
        }

        int a = prefix[s1.length() - 1];

        StringBuilder b = new StringBuilder(s.substring(a));
        b.reverse();

        b.append(s);

        return b.toString();

    }
}
