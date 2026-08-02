package dsa.GFG;

public class L8_Reverse_Digits {
    public int reverseDigits(int n) {
        // Code here
        int ans  = 0;
        while(n > 0) {
            ans = ans * 10 + n %10;
            n= n/ 10;

        }
        return ans;
    }
}

//TC : O(d)
//SC : O(1)

//public int reverseDigits(int n) {
//    // Code here
//    StringBuilder s = new StringBuilder(String.valueOf(n));
//    int i = 0;
//    int j = s.length() - 1;
//
//    while(i<j) {
//        swap(i, j, s);
//        i++;
//        j--;
//    }
//
//    return Integer.valueOf(s.toString());
//}
//
//
//public void swap(int i, int j, StringBuilder s) {
//    char temp = s.charAt(i);
//    s.setCharAt(i, s.charAt(j));
//    s.setCharAt(j, temp);
//
//}