package dsa.strings;

public class L2_Reverse_Words_In_A_String {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        StringBuilder ans = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            ans.append(arr[i]);
            if (i != 0) ans.append(" ");
        }

        return ans.toString();
    }
}

//TC : O(n)
//SC : O(n)