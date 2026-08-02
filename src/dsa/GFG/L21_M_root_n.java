package dsa.GFG;

public class L21_M_root_n {
    public int nthRoot(int n, int m) {
        // code here
        int start = 0;
        int end  = m;
        int ans  = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            ans = check(mid, n, m);
            if(ans == 1) {
                return mid;
            } else if(ans == 0) {
                start = mid +1;
            } else {
                end = mid -1;
            }
        }

        return -1;
    }

    int check(int mid, int n, int m) {
        long ans = 1;

        for (int i = 0; i < n; i++) {
            ans *= mid;

            if (ans > m)
                return 2;
        }

        if (ans == m)
            return 1;

        return 0;
    }
}

//TC : O(nlogm)
//SC : O(1)