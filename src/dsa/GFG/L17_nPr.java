package dsa.GFG;

public class L17_nPr {
    public long nPr(int n, int r) {
        // code here
        if(r >n) {
            return 0;
        }

        long ans = 1;
        for(int i=0; i<r; i++) {
            ans *= (n - i);
        }

        return ans;
    }
}

//TC : O(r)
//SC : O(1)