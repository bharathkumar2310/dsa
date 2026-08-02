package dsa.GFG;

public class L18_nCr {
    public int nCr(int n, int r) {
        // code here
        long ans = 1;
        for(int i=0; i<r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }

        return (int)ans;
    }
}
