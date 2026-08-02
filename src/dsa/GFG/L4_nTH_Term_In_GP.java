package dsa.GFG;


//for power method
//
//Generate powers x, x², x⁴, x⁸... by repeatedly squaring the base.
//Represent the exponent as a sum of powers of 2 (binary representation) and multiply only the required powers.
//This reduces exponentiation from O(n) to O(log n) time with O(1) extra space.
//
//
//Instead of multiplying the base n times, repeatedly square the base to generate powers x, x², x⁴, x⁸....
//If the current exponent is odd, multiply the current power with the answer; if even, square the base and halve the exponent.
//This reduces the time complexity from O(n) to O(log n).

public class L4_nTH_Term_In_GP {
    public int nthTerm(int a, int r, int n) {
        // code here
        int mod = (int)1e9 + 7;
        return (int)((a * pow(r, n-1)) %mod);
    }

    long pow(int r, int n) {
        long ans = 1;
        int mod = (int)1e9 + 7;
        long x =r;
        while(n!=0) {
            if(n%2 != 0) {
                ans = (ans * x)%mod;
                n= n-1;
            } else {
                x=(int)((x*x)%mod);
                n=n/2;
            }
        }

        return ans;
    }
}

//TC : O(logn)
//SC : O(1)

//nth term of Gp ==> a*(r^(n-1))
//sum of n terms ===> Sₙ = a(rⁿ − 1) / (r − 1) or Sₙ = a(1 − rⁿ) / (1 − r)
//Both formulas are the same. Use whichever avoids negative values depending on r.



//a, ar, ar², ar³, ... , ar^(n−1)
//
//Let the sum of the first n terms be:
//
//S = a + ar + ar² + ar³ + ... + ar^(n−1)
//
//Multiply the entire equation by r.
//
//rS = ar + ar² + ar³ + ... + ar^n
//
//Now subtract the first equation from the second.
//
//rS - S
//=
//        (ar + ar² + ... + ar^n)
//        -
//        (a + ar + ar² + ... + ar^(n−1))
//
//Everything cancels except the first and last terms.
//
//rS - S = ar^n - a
//
//Take S common.
//
//S(r - 1) = a(r^n - 1)
//
//Divide both sides by (r - 1).
//
//S = a(r^n - 1) / (r - 1)
//
//This is the sum of the first n terms when r ≠ 1.