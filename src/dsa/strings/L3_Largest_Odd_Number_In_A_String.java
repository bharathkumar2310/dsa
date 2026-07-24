package dsa.strings;

public class L3_Largest_Odd_Number_In_A_String {
    public String largestOddNumber(String num) {
        for(int i= num.length() - 1 ; i>=0; i--) {
            if((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}


//TC : O(n)
//SC : O(1)