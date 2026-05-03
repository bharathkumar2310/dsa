package dsa.Arrays;

import java.util.ArrayList;

public class L18_Pascal_Triangle {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
        long ans1 =1;
        ArrayList<Integer> ans = new ArrayList<>();
        int num = n-1;
        for(int i=0; i<n; i++) {
            if(i==0 || i==n-1) {
                ans.add(1);
            }
            else {
                ans1 = (ans1 * (num-i+1))/ i;
                ans.add((int)ans1);
            }
        }
        return ans;
    }
}

//TC : O(n)
// SC : O(n)