package dsa.GFG.puzzle;

public class L11_Nth_Fib_Last_Dig {
    public int fib(int n) {
        // code here
        n %= 60;
        if(n==0) {
            return 0;
        }
        int a = 0;
        int b = 1;

        for(int i=2; i<=n; i++) {
            int c = (a + b)%10;
            a=b;
            b=c;
        }

        return b;
    }
}

// TC : O(n % 60) = O(60) = O(1)
//SC : O(1)

// after n= 60 the sequence of last dig will repeat (a= 0, b=1)