package dsa.GFG;

public class L15_GCD_Of_Array {
    public int gcd(int n, int arr[]) {
        // code here.
        int ans  = arr[0];
        for(int i=1; i<n; i++) {
            ans = gcd(arr[i], ans);
        }

        return ans;
    }

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

//TC : O(n × log(M)), where M is the maximum element in the array
//SC : O(1)