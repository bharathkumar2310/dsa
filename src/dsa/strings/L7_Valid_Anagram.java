package dsa.strings;

public class L7_Valid_Anagram {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<26; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }

        return true;
    }
}


//TC : O(n + 26)
//SC : O(26)


//if it contains all unicode char use map instead of arr