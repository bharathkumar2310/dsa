package dsa.GFG;

public class L7_Sum_Of_Digits_In_No {
    static int sumOfDigits(int n) {
        // code here
        int ans = 0;
        while(n>0) {
            ans += n%10;
            n= n/10;
        }

        return ans;
    }
}

//TC : O(d)
//SC : O(1)