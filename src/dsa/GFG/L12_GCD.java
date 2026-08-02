package dsa.GFG;


//The GCD of two numbers does not change if we replace the larger number with its remainder when divided by the smaller number.
//Repeatedly transform (a, b) into (b, a % b), which makes the numbers smaller while preserving the GCD.
//When the remainder becomes 0, the other number is the GCD.
public class L12_GCD {
    public static int gcd(int a, int b) {
        // code here
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}

//TC : O(log(min(a,b))
//SC : O(1)



//Intuition 1 (Most Important)
//
//Suppose you want gcd(48, 18).
//
//The GCD is the largest number that divides both.
//
//Now observe:
//
//        48 = 18 × 2 + 12
//Any number that divides 48 and 18 must also divide 12 (because 48 - 18×2 = 12).
//
//So,
//
//gcd(48, 18) = gcd(18, 12)
//
//Repeat:
//
//gcd(18, 12)
//= gcd(12, 6)
//= gcd(6, 0)
//= 6
//
//When the remainder becomes 0, the other number is the answer.