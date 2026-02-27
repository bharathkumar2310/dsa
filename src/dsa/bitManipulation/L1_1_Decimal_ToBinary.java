package dsa.bitManipulation;

class L1_1_Decimal_ToBinary {
    static String decToBinary(int n) {
        StringBuilder ans = new StringBuilder();

        while(n > 0) {
            ans.append(n%2);
            n = n/2;
        }

        return ans.reverse().toString();
    }
}
