package dsa.strings;

import java.util.ArrayList;

public class L16_Rabin_Karp {

    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        // Code here
        int prime = 101;

        ArrayList<Integer> ans = new ArrayList<>();

        int pLength = pattern.length();
        int tLength = text.length();

        if(tLength < pLength || pattern.length() <= 0) {
            return new ArrayList<>();
        }
        int tHash = 0;
        int pHash = 0;
        for(int i=0; i< pLength; i++) {
            pHash += calculateHash(i, pattern);
            tHash += calculateHash(i, text);
        }

        for(int i=0; i<= tLength - pLength; i++) {
            if(tHash == pHash) {
                if(text.substring(i, i+ pLength).equals(pattern))
                    ans.add(i);
            }

            if(i < tLength - pLength) {
                tHash = updateHash(i, text, tHash, pLength);
            }

        }

        return ans;
    }

    int calculateHash(int i, String s) {
        return (int)((s.charAt(i) - 'a') * Math.pow(10, i));
    }

    int updateHash(int i, String text, int tHash, int pLength) {

        int sub = tHash - (text.charAt(i) - 'a');
        int div = sub/10;

        return (int)(div +  (text.charAt(i + pLength) - 'a') * Math.pow(10, pLength - 1));

    }


}


//TC : O(n + m-1)// avg
//     : O(n*m) worst


//SC : O(1)