package dsa.GFG;

public class L6_Amstrong_Number {

    static boolean armstrongNumber(int n) {
        // code here
        int x = n;
        int ans = 0;
        int digits = String.valueOf(n).length();
        while(x > 0) {
            int dig = x % 10;
            ans +=(int) power(dig, digits);
            x = x/10;
        }

        return ans == n;
    }


    static long power(int dig , int n) {
        long ans = 1;
        long x =dig;
        while(n>0) {
            if(n % 2 == 1) {
                ans *= x;
                n= n-1;
            } else {
                x*=x;
                n=n/2;
            }
        }

        return ans;

    }
}

//TC : O(nlogn) // n==> nod of digits
//SC : O(1)




// if only power by 3

//static boolean armstrongNumber(int n) {
//    // code here
//    int x = n;
//    int ans = 0;
//    while(x > 0) {
//        int dig = x % 10;
//        ans += dig * dig * dig;
//        x = x/10;
//    }
//
//    return ans == n;
//}
//TC : O(no of digit)
//SC : O(1)