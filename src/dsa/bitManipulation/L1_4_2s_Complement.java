package dsa.bitManipulation;
// 2s complement is needed to store negavtive nos
//This is how negavtive nos are stored
//
//+5 = 00000101
//-5 = 2's'ComplementOf(5)
//    = 11111010 + 1
//    = 11111011
//the last bit will always be 1 for negative
// now if u add -5 + 5 , we get 0

class L1_4_2s_Complement {
     String Twos_complement(String bi) {
        String oneComp = onesComplement(bi);
        return addOne(oneComp);
    }

     String onesComplement(String S) {
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<S.length(); i++) {
            ans.append((S.charAt(i) - '0') ^ 1);
        }
        return ans.toString();
    }

     String addOne(String s) {
        StringBuilder ans = new StringBuilder(s);
        int carry = 1;
        for(int i=s.length() - 1; i>=0; i--) {
            if(carry == 0) {
                break;
            }
            else{
                if(ans.charAt(i) == '0') {
                    ans.setCharAt(i, '1');
                    carry =0;
                }
                else{
                    ans.setCharAt(i, '0');
                }
            }
        }
        return ans.toString();
    }
}
