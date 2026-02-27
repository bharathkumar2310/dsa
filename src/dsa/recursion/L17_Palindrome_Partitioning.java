package dsa.recursion;

import java.util.ArrayList;
import java.util.List;

class L17_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ans1 = new ArrayList<>();
        rec(0, s.length(), s, ans, ans1);
        return ans;
    }

    void rec(int i, int j, String s, List<List<String>> ans, List<String> ans1) {

        if(i== s.length() ) {
            ans.add(new ArrayList<>(ans1));
        }


        for(int k=i; k<j; k++) {
            if(isPalindrome(i, k, s)) {

                ans1.add(s.substring(i,k + 1));
                rec(k + 1,j,s,ans, ans1);
                ans1.remove(ans1.size() - 1);
            }
        }

    }

    boolean isPalindrome(int i, int j , String s) {
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


//TC : O(n*(2^n))
//SC : O(n)
//   : O(n*(2^n))  ---> if output is included

