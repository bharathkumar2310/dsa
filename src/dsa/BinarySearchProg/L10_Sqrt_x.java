package dsa.BinarySearchProg;

public class L10_Sqrt_x {
    public int mySqrt(int x) {
        int start = 0;
        int end = x/2;
        int ans = 0;
        if(x==0 || x== 1) {
            return x;
        }
        while(start <= end) {
            int mid = (start + end) / 2;
            if((long)mid * (long)mid <= x) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
            else {
                end = mid -1;
            }
        }
        return ans;
    }
}

//TC : O(logn)
//SC : O(1)