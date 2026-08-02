package dsa.GFG;

public class L9_Kth_Digit_In_Power {
    static long kthDigit(int a, int b, int k) {
        // code here
        long ans = pow(a, b);
        int count = 1;
        while(ans > 0 && count != k) {
            count++;
            ans=ans/10;
        }

        return ans%10;
    }


    static long pow(int r, int n) {
        long ans = 1;
        long x =r;
        while(n!=0) {
            if(n%2 != 0) {
                ans = (ans * x);
                n= n-1;
            } else {
                x= (x*x);
                n=n/2;
            }
        }

        return ans;
    }
}

//TC : O(k + log b)
//SC : O(1)