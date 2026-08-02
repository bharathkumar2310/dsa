package dsa.GFG;

public class L13_LCM_And_GCD {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        int x =a;
        int y =b;
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        int gcd = a;

        int lcm = x/gcd * y/gcd * gcd;

        int[] ans =new int[2];
        ans[0] = lcm;
        ans[1] = gcd;

        return ans;
    }
}

//TC : O(log(min(a,b))
//SC : O(1)



//2. Brute Force
//
//Start from the larger number and keep checking multiples.
//
//int max = Math.max(a, b);
//
//while (true) {
//        if (max % a == 0 && max % b == 0)
//        return max;
//max++;
//        }
//
//Example:
//
//LCM(6,8)
//
//8 ❌
//9 ❌
//10 ❌
//11 ❌
//12 ❌
//...
//24 ✅
//
//TC: O(LCM)
//
//Very slow.