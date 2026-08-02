package dsa.GFG;

public class L10_Binary_To_Decimal {

    public int binaryToDecimal(String b) {
        // code here
        int ans  = 0;

        for (int i = 0; i < b.length(); i++) {
            ans = ans * 2 + (b.charAt(i) - '0');
        }

        return ans;
    }
}

//TC : O(n)
//SC : O(1)

//public int binaryToDecimal(String b) {
//    // code here
//    int ans  = 0;
//    int dig  =0;
//
//    for(int i=b.length() -1; i>=0; i--) {
//        int n = b.charAt(i) - '0';
//        if(n % 10 == 1) {
//            ans += (int)Math.pow(2,dig);
//        }
//        dig++;
//    }
//    return ans;
//}

//TC : O(n)
//SC : O(1)