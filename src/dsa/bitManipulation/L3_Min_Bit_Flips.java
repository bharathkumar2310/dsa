package dsa.bitManipulation;

class L3_Min_Bit_Flips {
    public int minBitFlips(int start, int goal) {
        return setBits(start ^ goal);
    }


    static int setBits(int n) {
        // code here
        int count = 0;
        while(n> 0) {
            n = n& n-1;
            count++;
        }
        return count;
    }
}
