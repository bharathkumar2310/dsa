package dsa.bitManipulation;

class L9_Divide_Two_Int_Without_Using_Division {
    public int divide(int dividend, int divisor) {

        // overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // use long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int ans = 0;

        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            shift--;

            ans += 1 << shift;
            a -= b << shift;
        }

        return negative ? -ans : ans;
    }
}

//    public int divide(int dividend, int divisor) {
//
//        if(dividend == Integer.MIN_VALUE && divisor == -1) {
//            return Integer.MAX_VALUE;
//        }
//
//        boolean isNegative = (dividend < 0) ^ (divisor < 0);
//        long a = Math.abs((long) dividend);
//        long b = Math.abs((long) divisor);
//
//        long sum = 0;
//        int count = 0;
//
//        while (sum + b <= a) {
//            sum += b;
//            count++;
//        }
//        return isNegative ? -1 * count : count;
//    }