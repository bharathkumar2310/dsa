package dsa.slidingWindow2pointer;

class L7_No_Of_Substring_Containing_All_3_Char {
    public int numberOfSubstrings(String s) {
        int a = -1;
        int b = -1;
        int c = -1;

        int right = 0;
        int count = 0;
        while(right < s.length()) {

            if(s.charAt(right) == 'a') {
                a = right;
            }
            if(s.charAt(right) == 'b') {
                b = right;
            }
            if(s.charAt(right) == 'c') {
                c = right;
            }
            if(a!=-1 && b!=-1 && c!=-1) {
                count += Math.min(a, Math.min(b,c)) + 1;
            }
            right++;
        }
        return count;
    }
}

//TC : O(n)
//SC : O(1)
