package dsa.strings;

public class L12_Longest_Palindrome_Sub_String {
    public String longestPalindrome(String s) {
        int len = 0;
        int start = 0;
        int end  = 0;
        for(int i=0; i<s.length(); i++) {
            len = findLen(s,i, i);
            len = Math.max(len, findLen(s,i, i + 1));
            if(len > end - start) {
                start = i - (len - 1)/2;
                end = i + (len/2);

            }
        }

        return s.substring(start, end + 1);
    }


    int findLen(String s, int i, int j) {
        while(i>= 0 && j< s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return j- i - 1;

    }
}

//TC : O(n^2)
//SC : O(1)