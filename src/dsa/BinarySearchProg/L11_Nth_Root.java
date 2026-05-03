package dsa.BinarySearchProg;

public class L11_Nth_Root {
    public int nthRoot(int n, int m) {
        // code here
        int start = 0;
        int end = m;

        while(start <= end) {
            int mid = (start + end) / 2;
            int ans = func(mid,n);
            if(ans == m) {
                return mid;
            }

            else if(ans > m) {
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }

        return -1;
    }

    int func(int mid, int n) {
        int ans = 1;
        while(n > 0) {
            if(n % 2 == 1) {
                ans = ans * mid;
                n = n-1;
            }
            else {
                mid = mid * mid;
                n = n/2;
            }
        }
        return ans;
    }


}

//TC : O(logn)
//SC : O(1)


//int func(int mid, int n) {
//    int ans = 1;
//    for(int i=0; i<n; i++) {
//        ans *= mid;
//    }
//    return ans;
//}