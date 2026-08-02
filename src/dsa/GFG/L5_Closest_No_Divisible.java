package dsa.GFG;

public class L5_Closest_No_Divisible {
    static int closestNumber(int n, int m) {
        // code here
        int a = n%m;

        int lower = n - a;

        int upper;

        if((n>0 && m>0) || (n < 0 && m<0)) {
            upper = lower + m;
        } else {
            upper = lower - m;
        }


        if(Math.abs(n - lower) == Math.abs(upper -n)) {
            return Math.max(lower, upper);
        }

        return (Math.abs(n - lower) < Math.abs(upper - n)) ? lower : upper;

    }
}

//TC : O(1)
//SC : O(1)

//
//Intuition (3-4 lines)
//Every number lies between two multiples of m—the nearest lower multiple and the nearest upper multiple.
//Find these two multiples using the remainder (n % m).
//Compare their distances from n and return the closer one.
//If both are equally close, return the greater multiple as per the problem statement.