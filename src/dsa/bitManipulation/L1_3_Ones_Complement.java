package dsa.bitManipulation;

class L1_3_Ones_Complement {
    static String onesComplement(String S, int N) {
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<S.length(); i++) {
            ans.append((S.charAt(i) - '0') ^ 1);

        }
        return ans.toString();
    }
}
