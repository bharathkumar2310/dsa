package dsa.GFG;

import java.util.ArrayList;

//n=3
//3 3 3 2 2 2 1 1 1
//3 3 2 2 1 1
//3 2 1
public class L1_Print_Pattern {

    public ArrayList<Integer> printPat(int n) {
        // write code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=n; i>=1; i--) {
            for(int j=n; j>=1; j--) {
                int x = i;
                while(x >0) {
                    ans.add(j);
                    x--;
                }
            }
            ans.add(-1);
        }
        return ans;
    }
}

//TC : O(N^3)
//SC : O(1)