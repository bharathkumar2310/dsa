package dsa.dp;

// same as L25_Longest_Common_SubSequence

public class L29_Min_Insertions_to_Make_String_Palindrome {
    public int minInsertions(String text1) {
        StringBuilder build = new StringBuilder(text1);
        String text2 = build.reverse().toString();

        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];

        for(int i=0; i<n; i++) {
            int[] curr = new int[m+1];
            for(int j=0; j<m; j++) {
                if(text1.charAt(i) == text2.charAt(j)) {

                    curr[j+1] = 1+ prev[j];

                }
                else{
                    curr[j+1] = Math.max(curr[j], prev[j+1]);
                }
            }

            prev = curr;
        }

        int lcs =  prev[m];
        return text1.length() - lcs;
    }
}

//TC : O(n*m)
//SC : O(2m)