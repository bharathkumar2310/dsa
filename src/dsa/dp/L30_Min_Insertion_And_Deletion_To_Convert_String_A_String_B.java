package dsa.dp;

// same as L25_Longest_Common_SubSequence

public class L30_Min_Insertion_And_Deletion_To_Convert_String_A_String_B {
    public int minOperations(String text1, String text2) {
        // Your code goes here


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
        return Math.abs(text1.length() + text2.length() -  2 *lcs);
    }
}

//TC : O(n*m)
//SC : O(2m)