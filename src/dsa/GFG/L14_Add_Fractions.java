package dsa.GFG;

//To add two fractions:
//
//num1 * den2 + num2 * den1/ den1 * den2
//Then simplify the answer by dividing the numerator and denominator by their GCD.

public class L14_Add_Fractions {
    void addFraction(int num1, int den1, int num2, int den2) {
        // Your code here
        int numerator = num1 * den2 + num2 * den1;
        int denominator = den1 * den2;

        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        System.out.println(numerator + "/" + denominator);
    }

    public int gcd(int a, int b) {
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