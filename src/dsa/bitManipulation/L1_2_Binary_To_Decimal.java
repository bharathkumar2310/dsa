package dsa.bitManipulation;

class L1_2_Binary_To_Decimal {
    public int binaryToDecimal(String b) {
        int n = b.length() -1;
        int ans = 0;
        int power = 1;
        while(n>=0) {

            if(b.charAt(n) == '1') {
                ans += (b.charAt(n) - '0') * power;
            }
            power*=2;
            n--;
        }
        return ans;
    }
}


//public int binaryToDecimal(String b) {
//    // Code here
//    int n = 0;
//    int ans = 0;
//    while(n<b.length()) {
//
//        ans = ans*2 + (b.charAt(n) - '0');
//        n++;
//    }
//    return ans;
//}